package com.sk.dao;

import com.sk.domain.StockModifyRecord;
import com.sk.domain.StockModifyRecordExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StockModifyRecordMapper {
    int countByExample(StockModifyRecordExample example);

    int deleteByExample(StockModifyRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockModifyRecord record);

    int insertSelective(StockModifyRecord record);

    List<StockModifyRecord> selectByExample(StockModifyRecordExample example);

    List<StockModifyRecord> selectWithProductAndCategory();

    List<StockModifyRecord> selectByNameWithProductAndCategory(@Param("productName") String productName);

    StockModifyRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockModifyRecord record, @Param("example") StockModifyRecordExample example);

    int updateByExample(@Param("record") StockModifyRecord record, @Param("example") StockModifyRecordExample example);

    int updateByPrimaryKeySelective(StockModifyRecord record);

    int updateByPrimaryKey(StockModifyRecord record);
}