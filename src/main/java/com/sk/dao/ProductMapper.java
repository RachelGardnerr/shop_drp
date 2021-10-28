package com.sk.dao;


import com.sk.domain.Product;
import com.sk.domain.ProductExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer id);

    Product selectByName(@Param("productName") String productName);


    List<Product> selectByExampleWithCategoryAndSupplier();

    List<Product> selectByNameWithCategoryAndSupplier(@Param("productName")String productName);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    int deleteProductById(@Param("id") Integer id);
}