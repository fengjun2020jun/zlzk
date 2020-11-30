package com.zlzk.common.enums;


/**
 * @author fj
 * @version 1.0
 * @date 2020/11/30 11:20
 */

public enum  MessageEnums {

    SYSTEM_ERROR(1001, "系统异常"),
    NAME_LIMIT(2000, "姓名超过了限制，最大4个字符!");

    private Integer code;

    private String msg;

    MessageEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
