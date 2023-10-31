package com.kevinliu.springboogmallpractice.service.impl;

import com.kevinliu.springboogmallpractice.dto.UserRegisterRequest;
import com.kevinliu.springboogmallpractice.model.User;
import com.kevinliu.springboogmallpractice.repo.UserDao;
import com.kevinliu.springboogmallpractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
