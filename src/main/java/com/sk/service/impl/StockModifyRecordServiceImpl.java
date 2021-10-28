package com.sk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sk.dao.StockModifyRecordMapper;
import com.sk.domain.StockModifyRecord;
import com.sk.service.StockModifyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class StockModifyRecordServiceImpl implements StockModifyRecordService {

    @Autowired
    private StockModifyRecordMapper stockModifyRecordMapper;

    @Override
    public int addRecord(StockModifyRecord stockModifyRecord) {
        if (stockModifyRecord != null) {
//            stockModifyRecord.setOperatorId(1);
            stockModifyRecord.setCreateTime(new Date());
            stockModifyRecord.setUpdateTime(new Date());
            return stockModifyRecordMapper.insertSelective(stockModifyRecord);
        }
        return 0;
    }

    @Override
    public PageInfo<StockModifyRecord> queryStockRecord(Integer pn) {
        PageHelper.startPage(pn, 8);
        List<StockModifyRecord> products = stockModifyRecordMapper.selectWithProductAndCategory();
        return new PageInfo<>(products);
    }

    @Override
    public PageInfo<StockModifyRecord> queryStockRecordByNameWithOtherMsg(String productName) {
        if (productName != null) {
            return new PageInfo<>(stockModifyRecordMapper.selectByNameWithProductAndCategory(productName));
        }
        return null;
    }
}
