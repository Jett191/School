package com.homework2.mapper;

import com.homework2.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Insert("INSERT INTO `user`(name, password, email, path, size, deleted) " +
      "VALUES(#{name}, #{password}, #{email}, #{path}, #{size}, #{deleted})")
  @Options(useGeneratedKeys = true, keyProperty = "userId")
  int insert(User user);

  @Select("SELECT user_id AS userId, name, password, email, path, size, deleted " +
      "FROM `user` WHERE email = #{email} AND deleted = 0")
  User findByEmail(String email);

  @Select("SELECT user_id AS userId, name, password, email, path, size, deleted " +
      "FROM `user` WHERE user_id = #{userId} AND deleted = 0")
  User findById(Integer userId);



}
