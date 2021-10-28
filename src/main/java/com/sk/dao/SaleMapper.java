package com.sk.dao;

import com.sk.domain.Product;
import com.sk.domain.Sale;
import com.sk.domain.SaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleMapper {
    int countByExample(SaleExample example);

    int deleteByExample(SaleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sale record);

    int insertSelective(Sale record);

    List<Sale> selectByExample(SaleExample example);

    List<Product> selectSale();

    Sale selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sale record, @Param("example") SaleExample example);

    int updateByExample(@Param("record") Sale record, @Param("example") SaleExample example);

    int updateByPrimaryKeySelective(Sale record);

    int updateByPrimaryKey(Sale record);

    List<Product> selectByNameWithSale(@Param("productName") String productName);

    int updateByBarCode(Sale sale);
}