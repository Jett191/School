package com.homework2.service;

import com.homework2.entity.User;
import com.homework2.input.UserLoginRequest;
import com.homework2.input.UserRegisterRequest;
import com.homework2.output.UserLoginInfoResponse;

public interface UserService {

  boolean register(UserRegisterRequest userInfo);


  UserLoginInfoResponse login(UserLoginRequest userInfo);
}
