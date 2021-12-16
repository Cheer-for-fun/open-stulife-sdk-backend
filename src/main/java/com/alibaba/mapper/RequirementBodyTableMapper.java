package com.alibaba.mapper;

import com.alibaba.bean.RequirementBodyTable;
import org.apache.ibatis.annotations.Param;

public interface RequirementBodyTableMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(@Param("record") RequirementBodyTable record);

    int insertSelective(RequirementBodyTable record);

    RequirementBodyTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RequirementBodyTable record);

    int updateByPrimaryKey(RequirementBodyTable record);
}