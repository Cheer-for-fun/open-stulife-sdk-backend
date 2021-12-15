package com.alibaba.mapper;

import com.alibaba.bean.UserUniversityTable;

public interface UserUniversityTableMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(UserUniversityTable record);

    int insertSelective(UserUniversityTable record);

    UserUniversityTable selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(UserUniversityTable record);

    int updateByPrimaryKey(UserUniversityTable record);
}