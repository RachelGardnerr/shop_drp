package com.sk.dao;

import com.sk.domain.Spec;
import com.sk.domain.SpecExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecMapper {
    int countByExample(SpecExample example);

    int deleteByExample(SpecExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Spec record);

    int insertSelective(Spec record);

    List<Spec> selectByExample(SpecExample example);

    Spec selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Spec record, @Param("example") SpecExample example);

    int updateByExample(@Param("record") Spec record, @Param("example") SpecExample example);

    int updateByPrimaryKeySelective(Spec record);

    int updateByPrimaryKey(Spec record);
}