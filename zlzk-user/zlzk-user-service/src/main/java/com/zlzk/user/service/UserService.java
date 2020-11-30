package com.zlzk.user.service;

import com.zlzk.common.exception.Result;
import com.zlzk.user.domain.User;

import java.util.List;

/**
 * @author fj
 * @version 1.0
 * @date 2020/11/29 16:50
 */
public interface UserService {


    Result<List<User>> getUser();

    Result<User> insertUser(User user);
}
