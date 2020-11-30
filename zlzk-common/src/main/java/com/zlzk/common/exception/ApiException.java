package com.zlzk.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiException extends RuntimeException {


    private Integer code;


    private String message;


    private Object data;


    public ApiException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }



}
