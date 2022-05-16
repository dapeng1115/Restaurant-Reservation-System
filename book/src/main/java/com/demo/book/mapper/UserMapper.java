package com.demo.book.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.book.model.po.User;

public interface UserMapper extends BaseMapper<User> {

  default User selectByUsername(String username) {
    LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(User::getUsername, username);
    return selectOne(queryWrapper);
  }
}
