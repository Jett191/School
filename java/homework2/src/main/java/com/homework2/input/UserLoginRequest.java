package com.homework2.input;

import lombok.Data;

@Data
public class UserLoginRequest {

  private String password;
  private String email;

}
