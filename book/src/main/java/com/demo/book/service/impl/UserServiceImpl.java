package com.demo.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.book.mapper.UserMapper;
import com.demo.book.model.po.User;
import com.demo.book.service.UserService;
import com.mblog.auth.util.JwtUtils;
import com.mblog.core.constant.ResponseCode;
import com.mblog.core.util.AssertUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

  @Override
  public String login(String username, String password) {
    User user = this.baseMapper.selectByUsername(username);
    AssertUtils.notNull(user, UserResponseCode.USER_NOT_EXISTED);
    AssertUtils.isTrue(user.getPassword().equals(password), UserResponseCode.WRONG_PASSWORD);
    return JwtUtils.generateToken(user);
  }

  @Override
  public void create(User user) {
    AssertUtils.notNull(user.getUsername(), UserResponseCode.USERNAME_NULL);
    AssertUtils.notNull(user.getPassword(), UserResponseCode.PASSWORD_NULL);
    AssertUtils.notNull(user.getRePassword(), UserResponseCode.REPASSWORD_NULL);
    AssertUtils.notNull(user.getRePassword(), UserResponseCode.REPASSWORD_NULL);
    AssertUtils.isTrue(user.getRePassword().equals(user.getPassword()), UserResponseCode.REPASSWORD_WRONG);
    AssertUtils.isNull(baseMapper.selectByUsername(user.getUsername()), UserResponseCode.USERNAME_EXISTED);
    baseMapper.insert(user);
  }

  @AllArgsConstructor
  public enum UserResponseCode implements ResponseCode {

    USER_NOT_EXISTED(10001, "User not existed!"),
    WRONG_PASSWORD(10002, "Wrong password!"),
    USERNAME_NULL(10003, "Username should not be null!"),
    PASSWORD_NULL(10004, "Password should not be null!"),
    REPASSWORD_NULL(10004, "Repeat password should not be null!"),
    REPASSWORD_WRONG(10006, "repeat password wrong!"),
    USERNAME_EXISTED(10004, "This username have already existed!");

    private final Integer code;
    private final String message;
    @Override
    public int getCode() {
      return code;
    }

    @Override
    public String getMessage() {
      return message;
    }
  }
}
