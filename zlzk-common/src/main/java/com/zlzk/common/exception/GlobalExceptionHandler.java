package com.zlzk.common.exception;


import com.alibaba.fastjson.JSONException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;


/**
 * @Description: ${todo} 这里用一句话描述这个类的作用
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result defaultErrorHandler(final HttpServletRequest req, final Exception e) {
        logger.error("未知异常", e);
        return Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), StringUtils.isEmpty(e.getMessage()) ? "unknown" : e.getMessage());
    }


    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Result MethodErrorHandler(final HttpServletRequest req, final Exception e) {
        logger.error("请求方法异常", e);
        return Result.error(HttpStatus.METHOD_NOT_ALLOWED.value(), e.getMessage());
    }


    @ExceptionHandler(value = {MethodArgumentNotValidException.class, JSONException.class,
            MissingServletRequestParameterException.class, MethodArgumentNotValidException.class,
            MultipartException.class, ConstraintViolationException.class, MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result BadRequestErrorHandler(final HttpServletRequest req, final Exception e) {
        logger.error("参数异常", e);
        return Result.error(HttpStatus.BAD_REQUEST.value(), e.getLocalizedMessage());
    }


    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    @ExceptionHandler(AsyncRequestTimeoutException.class)
    public Result handleAsyncRequestTimeoutException(AsyncRequestTimeoutException e, HttpServletRequest request) {
        System.out.println("time out");
        return Result.error(HttpStatus.REQUEST_TIMEOUT.value(), e.getMessage());
    }


    @ExceptionHandler(value = ApiException.class)
    public Result BaseErrorHandler(final HttpServletRequest req, HttpServletResponse response, final ApiException e) {
        logger.warn("api exception", e);
        HttpStatus status = HttpStatus.resolve(e.getCode());
        if (status != null) {
            response.setStatus(status.value());
        } else {
            response.setStatus(HttpStatus.OK.value());
        }
        return Result.error(e.getCode(), e.getMessage(), e.getData());
    }


}
