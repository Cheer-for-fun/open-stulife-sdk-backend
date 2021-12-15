package com.alibaba.mapper;

import com.alibaba.bean.UserBodyTable;
import org.apache.ibatis.annotations.Param;


public interface UserBodyTableMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserBodyTable record);

    int insertSelective(UserBodyTable record);

    UserBodyTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBodyTable record);

    int updateByPrimaryKey(UserBodyTable record);

    UserBodyTable selectByNameAndPassward(@Param("username") String username, @Param("password") String passward);

    UserBodyTable selectByUserName(String userName);

    int insertByUserName(@Param("userBodyTable") UserBodyTable userBodyTable, @Param("createTime") String createTime);
}