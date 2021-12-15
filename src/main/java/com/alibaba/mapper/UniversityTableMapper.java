package com.alibaba.mapper;

import com.alibaba.bean.UniversityTable;


public interface UniversityTableMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UniversityTable record);

    int insertSelective(UniversityTable record);


    UniversityTable selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(UniversityTable record);

    int updateByPrimaryKey(UniversityTable record);
}