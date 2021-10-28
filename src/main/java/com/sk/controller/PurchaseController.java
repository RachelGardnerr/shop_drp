package com.sk.controller;

import com.github.pagehelper.PageInfo;
import com.sk.domain.*;
import com.sk.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class PurchaseController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private StockService stockService;

    @Autowired
    private StockModifyRecordService recordService;

    //添加进货记录
    @GetMapping("addPurchase")
    public String addPurchase(Product product, Purchase purchase, Integer roleId) {
        if (purchase.getCount() < 0 || product.getSalePrice().compareTo(BigDecimal.ZERO) < 0) {
            return "purchase/input_result";
        }
        //保存进货商品信息
        productService.addProduct(product);
        //保存进货记录
        List<Product> products = productService.selectByName(product.getProductName());
        Product product1 = products.get(0);
        purchase.setProductId(product1.getId());
        BigDecimal count = new BigDecimal(purchase.getCount());
        purchase.setAmount(purchase.getPurchasePrice().multiply(count));
        purchaseService.addPurchaseService(purchase);
        //添加库存记录
        Stock stock = new Stock();
        stock.setProductBarCode(product.getBarCode());
        stock.setStockCount(purchase.getCount());
        stock.setCreateTime(new Date());
        stock.setUpdateTime(new Date());
        String lockKey = UUID.randomUUID().toString();
        stock.setLockKey(lockKey);
        stockService.addStock(stock);
        //添加变更记录
        StockModifyRecord stockModifyRecord = new StockModifyRecord();
        stockModifyRecord.setProductBarCode(product.getBarCode());
        stockModifyRecord.setOperatorId(roleId);
        stockModifyRecord.setModifyType("PURCHASE");
        stockModifyRecord.setModifyCount(purchase.getCount());
        recordService.addRecord(stockModifyRecord);
        return "purchase/input_result";
    }

    //查询所有进货记录
    @GetMapping("/queryAllPurchase")
    public String queryAllPurchase(@RequestParam(name = "pn", defaultValue = "1") Integer pn, String productName, Model model) {
        if (productName == null) {
            PageInfo<Purchase> productPageInfo = purchaseService.queryPurchaseWithOtherMsg(pn);
            model.addAttribute("purchases", productPageInfo);
            return "purchase/purchase_list";
        }

        PageInfo<Purchase> productPageInfo = purchaseService.queryPurchaseBYNameWithOtherMsg(productName);
        model.addAttribute("purchases", productPageInfo);
        return "purchase/purchase_list";
    }

    //跳转到更新商品页面
    @GetMapping("/toAddPurchase")
    public ModelAndView toAddPage() {
        ModelAndView mv = new ModelAndView();
        //查询所有品类和供给商信息，用于显示下拉列表框
        List<Category> categories = categoryService.queryAllCategory();
        List<Supplier> suppliers = supplierService.queryAllSupplier();
        mv.addObject("categories", categories);
        mv.addObject("suppliers", suppliers);
        mv.setViewName("purchase/purchase_input");
        return mv;
    }

}
