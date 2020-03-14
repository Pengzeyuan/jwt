package com.example.jwt.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.jwt.annotaion.Token;
import com.example.jwt.entity.User;
import com.example.jwt.service.IUserService;
import com.example.jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    @PostMapping("/login")
    public R login(String username, String password) {
        User user = userService.checkUserPwd(username, password);
        if (user == null) {
            return R.failed("用户名或密码不存在");
        }
        String token = JwtUtil.genToken(user);
        return R.ok(token);
    }

    /**
     * 修改用户（需要鉴定权限）
     * @param user 用户对象
     * @return 执行结果
     */
    @Token
    @PostMapping("/update")
    public R update(@RequestBody User user){
        return R.ok(userService.updateById(user));
    }

    /**
     * 添加用户（需要鉴定权限）
     * @param user 用户对象
     * @return
     */
    @Token
    @PostMapping("/add")
    public R add(@RequestBody User user){
        return R.ok(userService.save(user));
    }

    /**
     * 根据用户id查询用户，无需鉴权
     * @param id
     * @return
     */
    @GetMapping("/get")
    public R get(Integer id){
        return R.ok(userService.getById(id));
    }
}
