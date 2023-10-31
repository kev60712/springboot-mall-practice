package com.kevinliu.springboogmallpractice.repo;

import com.kevinliu.springboogmallpractice.dto.UserRegisterRequest;
import com.kevinliu.springboogmallpractice.model.User;
import lombok.Getter;
import lombok.Setter;


public interface UserDao {

    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
