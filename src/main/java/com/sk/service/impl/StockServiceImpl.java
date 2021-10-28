package com.sk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sk.dao.StockMapper;
import com.sk.domain.Product;
import com.sk.domain.Stock;
import com.sk.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class StockServiceImpl implements StockService {

    @Autowired
    private StockMapper stockMapper;

    @Override
    public int updateStock(Stock stock) {
        if (stock != null){
            return stockMapper.updateByPrimaryKeySelective(stock);
        }
        return 0;
    }

    @Override
    public Stock queryStockByBarCode(String productBarCode) {
        if (productBarCode != null){
            return stockMapper.selectByPrimaryKey(productBarCode);
        }
        return null;
    }

    @Override
    public int addStock(Stock stock) {
        if (stock != null){
            return stockMapper.insertSelective(stock);
        }
        return 0;
    }

    @Override
    public PageInfo<Product> queryStockByNameWithOtherMsg(String productName) {
        if (productName != null){
           return new PageInfo<>(stockMapper.selectStockByNameWithOtherMsg(productName));
        }
        return null;
    }

    @Override
    public PageInfo<Product> selectWithCategoryAndSupplierAndStock(Integer pn) {
        PageHelper.startPage(pn, 8);
        return new PageInfo<>(stockMapper.selectWithCategoryAndSupplierAndStock());
    }
}
