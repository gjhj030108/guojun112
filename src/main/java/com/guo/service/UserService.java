package com.guo.service;

import com.guo.pojo.User;

public interface UserService {
    User login(String username, String password);
}
