package com.sk.service;

import com.github.pagehelper.PageInfo;
import com.sk.domain.StockModifyRecord;

public interface StockModifyRecordService {
    PageInfo<StockModifyRecord> queryStockRecord(Integer pn);

    PageInfo<StockModifyRecord> queryStockRecordByNameWithOtherMsg(String productName);

    int addRecord(StockModifyRecord stockModifyRecord);
}
