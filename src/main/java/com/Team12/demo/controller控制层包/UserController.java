package com.Team12.demo.controller控制层包;

import com.Team12.demo.service业务逻辑接口包.UserService;
import com.Team12.demo.utils存放工具类.UserResult;
import com.Team12.demo.domain实体类包.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public UserResult<User> loginController(@RequestParam String uname, @RequestParam String password){
        User user = userService.loginService(uname, password);
        if(user!=null){
            if(user.getBaned() == true){
                return UserResult.error("3","该账号已被封禁！");
            }
            else{
                return UserResult.success(user,"登录成功！");
            }

        }else{
            return UserResult.error("1","账号或密码错误！");
        }
    }

    @PostMapping("/register")
    public UserResult<User> registController(@RequestBody User newUser){
        User user = userService.registService(newUser);
        if(user!=null){
            return UserResult.success(user,"注册成功！");
        }else{
            return UserResult.error("2","用户名已存在！");
        }
    }

    @PostMapping("/changePassword")
    public UserResult<User> changePasswordController(@RequestParam String uname , @RequestParam String oldPassword , @RequestParam String newPassword){
        User user = userService.changePasswordService(uname , oldPassword , newPassword);
        if(user!=null){
            return UserResult.success(user,"更改密码成功！");
        }
        else{
            return UserResult.error("4","旧密码不匹配！");
        }
    }

}