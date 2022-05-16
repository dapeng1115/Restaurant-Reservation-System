package com.demo.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.book.model.po.User;

public interface UserService extends IService<User> {

  String login(String username, String password);

  void create(User user);
}
