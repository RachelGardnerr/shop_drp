package com.sk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sk.dao.SaleMapper;
import com.sk.domain.Product;
import com.sk.domain.Sale;
import com.sk.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleMapper saleMapper;

    @Override
    public int addSale(Sale sale) {
        if (sale != null){
            return saleMapper.insertSelective(sale);
        }
        return 0;
    }

    @Override
    public PageInfo<Product> querySaleByNameWithOtherMsg(String productName) {
        PageHelper.startPage(1, 8);
        return new PageInfo<>(saleMapper.selectByNameWithSale(productName));
    }

    @Override
    public PageInfo<Product> queryAllSale(Integer pn) {
        PageHelper.startPage(pn, 8);
        return new PageInfo<>(saleMapper.selectSale());
    }
}
