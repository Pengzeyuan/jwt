package com.example.jwt.aspect;

import com.example.jwt.annotaion.Token;
import com.example.jwt.exception.NoTokenException;
import com.example.jwt.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author 袁仕俊
 * @version 1.0
 **/
@Aspect
@Component
public class TokenAspect {


    /**
     * 切入点
     * @param
     * @return
     * @Author 袁仕俊
     */
    @Pointcut("@annotation(com.example.jwt.annotaion.Token)")
    public void controllerAspect() {

    }

    @Before("controllerAspect()")
    public void methodBefore(JoinPoint joinPoint) throws NoTokenException {
        //获取目标类
        Class<?> cls =  joinPoint.getTarget().getClass();
        //获取目标方法名称
        String methodName = joinPoint.getSignature().getName();
        Method[] methods = cls.getMethods();
        Method method = null;
        for (Method m:methods){
            if(m.getName().equals(methodName)){
                method = m;
            }
        }
        //获取目标方法是否使用注解
        if(method.isAnnotationPresent(Token.class)){
            //获取request对象
            HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
            //获取token
            String token = request.getHeader("token");
            Claims claims = JwtUtil.checkToken(token);
            //token异常，抛出NoTokenException异常
            if(claims==null){
                throw new NoTokenException();
            }
        }
    }
}
