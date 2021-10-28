package com.sk.dao;

import com.sk.domain.SysRoleMenuMap;
import com.sk.domain.SysRoleMenuMapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuMapMapper {
    int countByExample(SysRoleMenuMapExample example);

    int deleteByExample(SysRoleMenuMapExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleMenuMap record);

    int insertSelective(SysRoleMenuMap record);

    List<SysRoleMenuMap> selectByExample(SysRoleMenuMapExample example);

    SysRoleMenuMap selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRoleMenuMap record, @Param("example") SysRoleMenuMapExample example);

    int updateByExample(@Param("record") SysRoleMenuMap record, @Param("example") SysRoleMenuMapExample example);

    int updateByPrimaryKeySelective(SysRoleMenuMap record);

    int updateByPrimaryKey(SysRoleMenuMap record);
}