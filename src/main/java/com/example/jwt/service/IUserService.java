package com.example.jwt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.jwt.entity.User;

public interface IUserService extends IService<User> {

    /**
     * 校验用户名和密码
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User checkUserPwd(String username,String password);

}
