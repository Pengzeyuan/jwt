package com.example.jwt;

import com.example.jwt.entity.User;
import com.example.jwt.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.Test;

public class JwtTest {

    /**
     * 获取token测试
     */
    @Test
    public void Jwt(){
        User user = new User();
        user.setId(999);
        user.setEmail("999@aq.com");
        user.setPassword("321456");
        user.setPhone("163765988");
        user.setUsername("junge666");
        String toekn = JwtUtil.genToken(user);
        System.out.println(toekn);
    }

    /**
     * 解密token测试
     */
    @Test
    public void jieMi(){
        Claims claims = JwtUtil.checkToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqd3QiLCJpZCI6OTk5LCJ1c2VybmFtZSI6Imp1bmdlNjY2IiwicGhvbmUiOiIxNjM3NjU5ODgiLCJpYXQiOjE1ODIxNjc2MDAsImV4cCI6MTU4MjE2NzY2MH0.mDfltXj16Yoil0jF7SvavML__qk-OubsRvRzzs_W_Xk");
        Object id = claims.get("id");
        Object username = claims.get("username");
        Object phone = claims.get("phone");
        System.out.println(id+"   "+username+"    "+phone);
    }
}
