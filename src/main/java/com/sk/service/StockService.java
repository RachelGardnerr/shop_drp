package com.sk.service;

import com.github.pagehelper.PageInfo;
import com.sk.domain.Product;
import com.sk.domain.Stock;


public interface StockService {

    PageInfo<Product> selectWithCategoryAndSupplierAndStock(Integer pn);

    PageInfo<Product> queryStockByNameWithOtherMsg(String productName);

    int addStock(Stock stock);


    Stock queryStockByBarCode(String productBarCode);

    int updateStock(Stock stock);
}
