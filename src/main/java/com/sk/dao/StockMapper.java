package com.sk.dao;

import com.sk.domain.Product;
import com.sk.domain.Stock;
import com.sk.domain.StockExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StockMapper {
    int countByExample(StockExample example);

    int deleteByExample(StockExample example);

    int deleteByPrimaryKey(String productBarCode);

    int insert(Stock record);

    int insertSelective(Stock record);

    List<Stock> selectByExample(StockExample example);

    Stock selectByPrimaryKey(String productBarCode);

    List<Product> selectWithCategoryAndSupplierAndStock();

    List<Product> selectStockByNameWithOtherMsg(@Param("productName") String productName);

    int updateByExampleSelective(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByExample(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);


//    int updateStockByProductBarCode(@Param("productBarCode") String productBarCode,@Param("count") Integer count);
}