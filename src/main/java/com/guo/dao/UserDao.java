package com.guo.dao;

import com.guo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    //根据name和password查询用户
    User selectUserByUsernameAndPassword(String username,String password);
}
