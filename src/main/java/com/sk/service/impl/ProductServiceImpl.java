package com.sk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sk.dao.ProductMapper;
import com.sk.domain.Product;
import com.sk.domain.ProductExample;
import com.sk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> selectByBarCode(String productBarCode) {
        if (productBarCode != null){
            ProductExample example = new ProductExample();
            example.createCriteria().andBarCodeEqualTo(productBarCode);
            return productMapper.selectByExample(example);
        }
        return Collections.emptyList();
    }

    @Override
    public List<Product> selectByName(String productName) {
        if (productName != null) {
            ProductExample example = new ProductExample();
            example.createCriteria().andProductNameEqualTo(productName);
            return productMapper.selectByExample(example);
        }
        return Collections.emptyList();
    }

    @Override
    public int addProduct(Product product) {
        if (product != null) {
            product.setId(null);
            product.setCreateTime(new Date());
            product.setUpdateTime(new Date());
            product.setDeleted(true);
            return productMapper.insertSelective(product);
        }
        return 0;
    }

    @Override
    public List<Product> selectAllProduct() {
        return productMapper.selectByExample(null);
    }

    @Override
    public Product selectByPrimaryKey(Integer id) {
        if (id != null) {
            return productMapper.selectByPrimaryKey(id);
        }
        return null;
    }

    @Override
    public int updateProduct(Product product) {
        if (product != null) {
            return productMapper.updateByPrimaryKeySelective(product);
        }
        return 0;
    }

    @Override
    public int deleteProductById(Integer id) {
        if (id != null) {
            return productMapper.deleteProductById(id);
        }
        return 0;
    }

    @Override
    public PageInfo<Product> selectByExampleWithOtherMsg(Integer pn) {
        PageHelper.startPage(pn, 8);
        ProductExample example = new ProductExample();
        example.createCriteria().andDeletedEqualTo(true);
        return new PageInfo<>(productMapper.selectByExampleWithCategoryAndSupplier());
    }

    @Override
    public PageInfo<Product> queryProductByName(String productName) {
        if (productName != null) {
            return new PageInfo<>(productMapper.selectByNameWithCategoryAndSupplier(productName));
        }
        return null;
    }


}
