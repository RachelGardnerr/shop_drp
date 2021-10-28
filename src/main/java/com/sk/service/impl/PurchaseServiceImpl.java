package com.sk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sk.dao.PurchaseMapper;
import com.sk.domain.Purchase;
import com.sk.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseMapper purchaseMapper;


    @Override
    public PageInfo<Purchase> queryPurchaseBYNameWithOtherMsg(String productName) {
        PageHelper.startPage(1,8);
        return new PageInfo<>(purchaseMapper.selectByNameWithCategoryAndSupplierAndProduct(productName));
    }

    @Override
    public PageInfo<Purchase> queryPurchaseWithOtherMsg(Integer pn) {
        PageHelper.startPage(pn,8);
        return new PageInfo<>(purchaseMapper.selectWithCategoryAndSupplierAndProduct());
    }

    @Override
    public int addPurchaseService(Purchase purchase) {
        if (purchase != null) {
            purchase.setCreateTime(new Date());
            purchase.setUpdateTime(new Date());
            purchase.setDeleted(true);
            return purchaseMapper.insertSelective(purchase);
        }
        return 0;
    }
}
