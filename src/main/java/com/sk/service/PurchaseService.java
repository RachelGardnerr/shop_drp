package com.sk.service;

import com.github.pagehelper.PageInfo;
import com.sk.domain.Product;
import com.sk.domain.Purchase;


public interface PurchaseService {

    int addPurchaseService(Purchase purchase);


    PageInfo<Purchase> queryPurchaseWithOtherMsg(Integer pn);

    PageInfo<Purchase> queryPurchaseBYNameWithOtherMsg(String productName);




}
