package com.example.jwt.config;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.jwt.exception.NoTokenException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕获
 */
@RestControllerAdvice
public class CatchException {

    @ExceptionHandler(value = NoTokenException.class)
    public R<?> handleGlobalException(NoTokenException e){
        return R.failed("token异常！请重新登录");
    }
}
