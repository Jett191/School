package com.homework2.service;

import com.homework2.entity.User;
import com.homework2.input.UserLoginRequest;
import com.homework2.input.UserRegisterRequest;

public interface UserService {
  /**
   * 注册新用户，返回 true 表示注册成功（用户名和邮箱都不重复）
   */
  boolean register(UserRegisterRequest userInfo);

  /**
   * 登录：根据用户名和密码返回 User 实体，密码不匹配或用户不存在则返回 null
   */
  User login(UserLoginRequest userInfo);
}
