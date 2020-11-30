package com.zlzk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author fj
 * @version 1.0
 * @date 2020/11/29 15:43
 */

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class UserApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApiApplication.class,args);
    }
}
