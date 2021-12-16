package com.alibaba.mapper;

import com.alibaba.bean.RequirementCommentTable;

public interface RequirementCommentTableMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(RequirementCommentTable record);

    int insertSelective(RequirementCommentTable record);


    RequirementCommentTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RequirementCommentTable record);

    int updateByPrimaryKey(RequirementCommentTable record);
}