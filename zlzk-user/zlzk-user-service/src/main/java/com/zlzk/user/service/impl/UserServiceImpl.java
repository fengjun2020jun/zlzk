package com.zlzk.user.service.impl;

import com.zlzk.common.exception.Result;
import com.zlzk.user.domain.User;
import com.zlzk.user.mapper.UserMapper;
import com.zlzk.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fj
 * @version 1.0
 * @date 2020/11/29 16:51
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Result<List<User>> getUser() {
        List<User> userList = userMapper.selectAll();
        return Result.success(userList);
    }

    @Override
    public Result<User> insertUser(User user) {
        return userMapper.insertUser(user);
    }
}
