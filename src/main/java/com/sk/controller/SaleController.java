package com.sk.controller;

import com.github.pagehelper.PageInfo;
import com.sk.domain.*;
import com.sk.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private ProductService productService;

    @Autowired
    private StockModifyRecordService recordService;

    @Autowired
    private StockService stockService;


    //跳转到销售页面
    @GetMapping("/toSellPage")
    public String toSellPage(Model model) {
        List<Product> products = productService.selectAllProduct();
        model.addAttribute("products", products);
        return "sale/do_sale";
    }

    //销售商品
    @PostMapping("/sellProduct")
    public String sellProduct(Sale sale, Integer roleId,Model model) {
        if (sale.getSaleCount() < 0) {
            return "sale/do_sale";
        }
        List<Product> products = productService.selectByBarCode(sale.getProductBarCode());
        if (products.isEmpty()) {
            return "sale/do_sale_result";
        } else {
            //更新库存
            Stock stock = stockService.queryStockByBarCode(sale.getProductBarCode());
            stock.setUpdateTime(new Date());
            int num = stock.getStockCount() - sale.getSaleCount();
            if (num < 0){
                model.addAttribute("sellMsg","销售数量不能大于库存数量【"+ stock.getStockCount()+"】");
                return "sale/do_sale";
            }
            //模拟销售
            sale.setCreateTime(new Date());
            sale.setUpdateTime(new Date());
            BigDecimal count = new BigDecimal(sale.getSaleCount());
            sale.setSaleAmount(sale.getSalePrice().multiply(count));
            saleService.addSale(sale);
            stock.setStockCount(num);
            stockService.updateStock(stock);
            //添加变更记录
            StockModifyRecord stockModifyRecord = new StockModifyRecord();
            stockModifyRecord.setProductBarCode(sale.getProductBarCode());
            stockModifyRecord.setOperatorId(roleId);
            stockModifyRecord.setModifyType("SALE");
            stockModifyRecord.setModifyCount(sale.getSaleCount());
            recordService.addRecord(stockModifyRecord);
            return "redirect:/queryAllSale";
        }
    }

    //查询所有记录
    @GetMapping("/queryAllSale")
    public String queryAllSale(@RequestParam(name = "pn", defaultValue = "1") Integer pn, String productName, Model model) {
        if (productName == null) {
            PageInfo<Product> productPageInfo = saleService.queryAllSale(pn);
            model.addAttribute("sales", productPageInfo);
            return "sale/sale_list";
        }
        PageInfo<Product> productPageInfo = saleService.querySaleByNameWithOtherMsg(productName);
        model.addAttribute("sales", productPageInfo);
        return "sale/sale_list";
    }

}
