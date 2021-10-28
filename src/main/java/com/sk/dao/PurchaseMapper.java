package com.sk.dao;

import com.sk.domain.Product;
import com.sk.domain.Purchase;
import com.sk.domain.PurchaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseMapper {
    int countByExample(PurchaseExample example);

    int deleteByExample(PurchaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    List<Purchase> selectByExample(PurchaseExample example);

    Purchase selectByPrimaryKey(Integer id);

    List<Purchase> selectWithCategoryAndSupplierAndProduct();

    List<Purchase> selectByNameWithCategoryAndSupplierAndProduct(@Param("productName") String productName);

    int updateByExampleSelective(@Param("record") Purchase record, @Param("example") PurchaseExample example);

    int updateByExample(@Param("record") Purchase record, @Param("example") PurchaseExample example);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);

    Purchase selectByproductBarCode(String productBarCode);

}