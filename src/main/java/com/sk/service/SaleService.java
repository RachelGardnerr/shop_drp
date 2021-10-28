package com.sk.service;

import com.github.pagehelper.PageInfo;
import com.sk.domain.Product;
import com.sk.domain.Sale;



public interface SaleService {

    PageInfo<Product> queryAllSale(Integer pn);


    PageInfo<Product> querySaleByNameWithOtherMsg(String productName);

    int  addSale(Sale sale);
}
