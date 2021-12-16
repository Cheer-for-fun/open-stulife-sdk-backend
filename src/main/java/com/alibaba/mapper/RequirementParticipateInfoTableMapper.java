package com.alibaba.mapper;

import com.alibaba.bean.RequirementParticipateInfoTable;

public interface RequirementParticipateInfoTableMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(RequirementParticipateInfoTable record);

    int insertSelective(RequirementParticipateInfoTable record);


    RequirementParticipateInfoTable selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(RequirementParticipateInfoTable record);

    int updateByPrimaryKey(RequirementParticipateInfoTable record);
}