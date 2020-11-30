package com.zlzk.user.mapper;

import com.zlzk.common.exception.Result;
import com.zlzk.common.mapper.CommonMapper;
import com.zlzk.user.domain.User;

/**
 * @author fj
 * @version 1.0
 * @date 2020/11/29 17:06
 */
public interface UserMapper extends CommonMapper<User> {
    Result<User> insertUser(User user);
}
