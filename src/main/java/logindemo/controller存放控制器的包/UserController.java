package logindemo.controller存放控制器的包;


import logindemo.domain存放实体类.User;
import logindemo.service存放业务逻辑接口.UserService;
import logindemo.utils存放工具类.UserResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    //实现登录控制
    @PostMapping("/login")
    public UserResult<User> loginController(@RequestParam String id, @RequestParam String password){
        User user = userService.loginService(id, password);
        if(user != null){
            return UserResult.success(user,"登录成功！");
        }
        else{
            return UserResult.error("123","账号或密码错误！");
        }
    }
    //实现注册控制
    @PostMapping("/register")
    public UserResult<User> registController(@RequestBody User newUser){
        User user = userService.registService(newUser);
        if(user != null){
            return UserResult.success(user,"注册成功！");
        }else{
            return UserResult.error("456","用户名已存在！");
        }
    }

}
