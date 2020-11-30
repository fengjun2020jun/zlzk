package com.zlzk.service;

import com.zlzk.common.constant.ServiceProviderConstant;
import com.zlzk.common.exception.Result;
import com.zlzk.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author fj
 * @version 1.0
 * @date 2020/11/29 15:46
 */

@FeignClient(value = ServiceProviderConstant.USER_SERVICE_PROVIDER_NAME + "/rpc/userClient")
public interface UserService {


    @GetMapping("users")
    Result<List<User>> users();

}
