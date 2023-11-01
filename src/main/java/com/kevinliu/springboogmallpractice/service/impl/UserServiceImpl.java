package com.kevinliu.springboogmallpractice.service.impl;

import com.kevinliu.springboogmallpractice.dto.UserLoginRequest;
import com.kevinliu.springboogmallpractice.dto.UserRegisterRequest;
import com.kevinliu.springboogmallpractice.model.User;
import com.kevinliu.springboogmallpractice.repo.UserDao;
import com.kevinliu.springboogmallpractice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        // Check if the user exist
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        if (user != null){
            log.warn("This email {} has been enrolled", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // Use MD5 to generate hash value for password
        String hashedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
        userRegisterRequest.setPassword(hashedPassword);

        // Create user
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = userDao.getUserByEmail(userLoginRequest.getEmail());

        if (user == null){
            log.warn("This email {} is not registered yet", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // Use MD5 to generate hash value for password
        String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());

        if (user.getPassword().equals(hashedPassword)){
            return user;
        }else{
            log.warn("Input password is wrong");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
