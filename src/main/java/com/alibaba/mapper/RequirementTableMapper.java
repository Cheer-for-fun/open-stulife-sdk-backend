package com.alibaba.mapper;

import com.alibaba.bean.RequirementTable;

import java.util.List;

public interface RequirementTableMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RequirementTable record);

    int insertSelective(RequirementTable record);


    RequirementTable selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(RequirementTable record);

    int updateByPrimaryKey(RequirementTable record);

    List<RequirementTable> selectAll();
}