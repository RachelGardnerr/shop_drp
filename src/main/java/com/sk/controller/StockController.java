package com.sk.controller;

import com.github.pagehelper.PageInfo;
import com.sk.domain.Product;
import com.sk.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/queryAllStock")
    public String getStockList(@RequestParam(name = "pn", defaultValue = "1") Integer pn, String productName, Model model) {
        if (productName == null) {
            PageInfo<Product> productPageInfo = stockService.selectWithCategoryAndSupplierAndStock(pn);
            model.addAttribute("stocks", productPageInfo);
            return "stock/stock_list";
        }
        PageInfo<Product> productPageInfo = stockService.queryStockByNameWithOtherMsg(productName);
        model.addAttribute("stocks", productPageInfo);
        return "stock/stock_list";
    }

}
