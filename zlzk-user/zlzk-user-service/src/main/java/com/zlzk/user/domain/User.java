package com.zlzk.user.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author fj
 * @version 1.0
 * @date 2020/11/29 13:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "User",description = "用户信息")
public class User implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;
}
