package com.homework2.input;

import lombok.Data;

@Data
public class UserRegisterRequest {
  private String name;
  private String password;
  private String email;
}
