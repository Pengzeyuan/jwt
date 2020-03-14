package com.example.jwt.util;

import com.example.jwt.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * jwt工具类
 */
public class JwtUtil {
    //项目名称
    private static final String SUBJECT = "jwt";

    //过期时间
    private static final long EXP_TIME = 1000 * 60 * 60;

    //秘钥
    private static final String APPSECRET = "junge";

    /**
     * 生成token
     *
     * @param user
     * @return
     */
    public static String genToken(User user) {

        if (user.getId() == null || user.getUsername() == null || user.getPassword() == null) {
            return null;
        }

        String token = Jwts.builder().setSubject(SUBJECT)  //开始构建
                .claim("id", user.getId())              //设置需要加密的属性
                .claim("username", user.getUsername())
                .claim("phone", user.getPhone())
                .setIssuedAt(new Date())                    //设置构建时间
                .setExpiration(new Date(System.currentTimeMillis() + EXP_TIME)) //设置过期时间
                .signWith(SignatureAlgorithm.HS256, APPSECRET)  //设置加密方式和秘钥
                .compact();                                 //生成token

        return token;
    }

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public static Claims checkToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
        }
        return null;
    }
}
