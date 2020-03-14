package com.example.jwt.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.jwt.entity.User;
import com.example.jwt.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {
    @Override
    public User checkUserPwd(String username, String password) {
        User user = baseMapper.selectOne(new QueryWrapper<User>()
                .eq("username",username)
                .eq("password",password));
        return user;
    }


}
