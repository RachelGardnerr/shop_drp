package com.sk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sk.dao.SupplierMapper;
import com.sk.domain.Supplier;
import com.sk.domain.SupplierExample;
import com.sk.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public int deleteSupplier(Integer id) {
        if (id != null){
            return supplierMapper.deleteByPrimaryKey(id);
        }
        return 0;
    }

    @Override
    public int updateSupplier(Supplier supplier) {
        if (supplier != null){
            supplier.setUpdateTime(new Date());
            return supplierMapper.updateByPrimaryKeySelective(supplier);
        }
        return 0;
    }

    @Override
    public Supplier selectByPrimaryKey(Integer supplierId) {
        if (supplierId != null){
            return supplierMapper.selectByPrimaryKey(supplierId);
        }
        return null;
    }

    @Override
    public int addSupplier(Supplier supplier) {
        if (supplier != null) {
            return supplierMapper.insertSelective(supplier);
        }
        return 0;
    }

    @Override
    public PageInfo<Supplier> querySupplierByName(String supplierName) {
        if (supplierName != null) {
            SupplierExample example = new SupplierExample();
            example.createCriteria().andSupplierNameEqualTo(supplierName);
            return new PageInfo<>(supplierMapper.selectByExample(example));
        }
        return null;
    }

    @Override
    public List<Supplier> queryAllSupplier() {
        return supplierMapper.selectByExample(null);
    }

    @Override
    public PageInfo<Supplier> queryAllSupplierWithPn(Integer pn) {
        PageHelper.startPage(pn, 8);
        return new PageInfo<>(supplierMapper.selectByExample(null));
    }
}
