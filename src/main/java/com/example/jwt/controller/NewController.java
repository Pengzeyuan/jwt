package com.example.jwt.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.jwt.annotaion.Token;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 测试
 * </p >
 *
 * @author 袁仕俊
 * @Version: V1.0
 * @since 2020-02-21 9:33
 */
@RestController
@RequestMapping("/test")
public class NewController {

    @GetMapping("/test")
    @Token
    public R test(){
        return R.ok("测试");
    }
}
