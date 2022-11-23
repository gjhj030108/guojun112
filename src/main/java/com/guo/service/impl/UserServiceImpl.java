package com.guo.service.impl;

import com.guo.dao.UserDao;
import com.guo.pojo.User;
import com.guo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userdao;
    @Override
    public User login(String username, String password) {
        return userdao.selectUserByUsernameAndPassword(username, password);
    }
}
