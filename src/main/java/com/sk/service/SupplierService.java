package com.sk.service;

import com.github.pagehelper.PageInfo;

import com.sk.domain.Supplier;

import java.util.List;

public interface SupplierService {

    List<Supplier> queryAllSupplier();

    PageInfo<Supplier> queryAllSupplierWithPn(Integer pn);


    PageInfo<Supplier> querySupplierByName(String supplierName);

    int addSupplier(Supplier supplier);

    Supplier selectByPrimaryKey(Integer supplierId);

    int updateSupplier(Supplier supplier);

    int deleteSupplier(Integer id);
}
