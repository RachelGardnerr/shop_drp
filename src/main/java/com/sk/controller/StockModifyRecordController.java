package com.sk.controller;

import com.github.pagehelper.PageInfo;
import com.sk.domain.StockModifyRecord;
import com.sk.service.StockModifyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StockModifyRecordController {

    @Autowired
    private StockModifyRecordService stockModifyRecordService;


    @GetMapping("/queryAllStockModifyRecord")
    public String queryAllStockRecord(@RequestParam(name = "pn", defaultValue = "1") Integer pn, String productName, Model model) {
        if (productName == null) {
            PageInfo<StockModifyRecord> stockRecordPageInfo = stockModifyRecordService.queryStockRecord(pn);
            model.addAttribute("stockRecordPageInfo", stockRecordPageInfo);
            return "stock/stock_recorder_list";
        }

        PageInfo<StockModifyRecord> stockRecordPageInfo = stockModifyRecordService.queryStockRecordByNameWithOtherMsg(productName);
        model.addAttribute("stockRecordPageInfo", stockRecordPageInfo);
        return "stock/stock_recorder_list";
    }

}
