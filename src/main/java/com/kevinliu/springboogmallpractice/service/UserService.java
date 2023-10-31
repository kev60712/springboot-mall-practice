package com.kevinliu.springboogmallpractice.service;

import com.kevinliu.springboogmallpractice.dto.UserLoginRequest;
import com.kevinliu.springboogmallpractice.dto.UserRegisterRequest;
import com.kevinliu.springboogmallpractice.model.User;

public interface UserService {

    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);

    User getUserById(Integer userId);

}
