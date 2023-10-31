package com.kevinliu.springboogmallpractice.service;

import com.kevinliu.springboogmallpractice.dto.UserRegisterRequest;
import com.kevinliu.springboogmallpractice.model.User;

public interface UserService {

    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

}
