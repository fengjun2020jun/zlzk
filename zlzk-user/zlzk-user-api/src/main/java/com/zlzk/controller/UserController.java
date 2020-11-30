package com.zlzk.controller;

import com.zlzk.common.exception.Result;
import com.zlzk.pojo.User;
import com.zlzk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fj
 * @version 1.0
 * @date 2020/11/29 16:01
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "consumer/users")
    public Result<List<User>> getUser(){
      return userService.users();
    }
}
