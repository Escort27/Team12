package com.Team12.YQdemo.controller控制层包;

import com.Team12.YQdemo.domain实体类包.User;
import com.Team12.YQdemo.service业务逻辑接口包.UserService;
import com.Team12.YQdemo.utils存放工具类.UserResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @PostMapping("/changeInformation")
    public UserResult<User> changeInformationService(@RequestParam String uname , @RequestParam int newYear , @RequestParam String newMajor , @RequestParam int newClass , @RequestParam String newNickname){
        User user = userService.changeInformationService(uname , newYear , newMajor , newClass , newNickname);
        if(user!=null){
            return UserResult.success(user,"修改资料成功！");
        }
        else{
            return UserResult.error("5","资料没有变更！");
        }
    }

    @PostMapping("/manager/banUser")
    public UserResult<User>  banUserService(@RequestParam String uname , @RequestParam boolean ban){
        User user = userService.banUserService(uname , ban);
        return UserResult.success(user , "变更账户状态成功！");
    }

    @PostMapping("/classSelect/userList")
    public List<User>  classSelect_userList(@RequestParam String umajor , @RequestParam int grade , @RequestParam int uclass){
        List<User> userList = userService.classListService(umajor , grade , uclass);
        return userList;
    }

    @PostMapping("/classSelect/join")
    public UserResult<User>  classSelect_userList(@RequestParam String uname , @RequestParam String realname , @RequestParam String sno){
        User user = userService.classJoinService(uname , realname , sno);
        return UserResult.success(user , "加入班级成功！");
    }
}
