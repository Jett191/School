package com.homework2.service.impl;


import com.homework2.entity.User;
import com.homework2.input.UserLoginRequest;
import com.homework2.input.UserRegisterRequest;
import com.homework2.mapper.UserMapper;
import com.homework2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  @Transactional
  public boolean register(UserRegisterRequest userInfo) {
    if (userMapper.findByEmail(userInfo.getEmail()) != null) return false;

    User user = new User();
    user.setEmail(userInfo.getEmail());
    user.setName(userInfo.getName());
    user.setPassword(userInfo.getPassword());
    user.setSize(500.00);

    // Todo
    user.setPath("");

    return userMapper.insert(user) > 0;
  }

  @Override
  public User login(UserLoginRequest userInfo) {


    if (userMapper.findByEmail(userInfo.getEmail()) == null) return null;


    return null;
  }
}
