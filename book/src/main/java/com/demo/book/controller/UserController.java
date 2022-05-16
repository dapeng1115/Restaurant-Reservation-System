package com.demo.book.controller;

import com.demo.book.model.po.User;
import com.demo.book.service.UserService;
import com.mblog.auth.annotation.PassAuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/signup")
  public String toSignup() {
    return "signup";
  }

  @PostMapping("/signup")
  @PassAuthToken
  public String create(User user) throws Exception {
    userService.create(user);
    return "success";
  }

  @GetMapping({"/login", "/"})
  public String toLogin() {
    return "login";
  }

  @PostMapping("/login")
  @PassAuthToken
  public String login(String username, String password, HttpSession session) {
    session.setAttribute("token", userService.login(username, password));
    return "success";
  }

}
