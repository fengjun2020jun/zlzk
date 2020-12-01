package com.zlzk.user.controller.api;

import com.zlzk.common.exception.Result;
import com.zlzk.user.domain.User;
import com.zlzk.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fj
 * @version 1.0
 * @date 2020/11/29 13:04
 */
@RestController
@RequestMapping(value = "api/user")
@Api("用户相关接口")
@Slf4j
public class UserApiController {

    @Autowired
    UserService userService;


    @ApiOperation(value = "查询所有用户",notes = "查询用户信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = User.class)))})
    @GetMapping(value = "users")
    public Result<List<User>> getUser(){
        return userService.getUser();
    }
}
