package com.sk.service;

import com.github.pagehelper.PageInfo;
import com.sk.domain.Product;

import java.util.List;

public interface ProductService {

    PageInfo<Product> selectByExampleWithOtherMsg(Integer pn);

    PageInfo<Product> queryProductByName(String productName);

    int deleteProductById(Integer id);

    int updateProduct(Product product);

    Product selectByPrimaryKey(Integer id);

    List<Product> selectAllProduct();

    int addProduct(Product product);

    List<Product> selectByName(String productName);

    List<Product> selectByBarCode(String productBarCode);
}
