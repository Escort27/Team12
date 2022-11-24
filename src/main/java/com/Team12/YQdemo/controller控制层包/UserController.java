package com.Team12.YQdemo.controller控制层包;

import com.Team12.YQdemo.domain实体类包.User;
import com.Team12.YQdemo.domain实体类包.uClass;
import com.Team12.YQdemo.service业务逻辑接口包.UserService;
import com.Team12.YQdemo.utils存放工具类.UserResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;

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
                return UserResult.error("2","账号已被封禁!");
            }
            else{
                return UserResult.success(user , "登陆成功!");//登录成功
            }
        }else{
            return UserResult.error("1","用户未注册或账号密码错误！");
        }
    }

    @PostMapping("/register")
    public HashMap<Integer , String> registController(@RequestParam String uname , @RequestParam String nickname , @RequestParam String password , @RequestParam String grade , @RequestParam String umajor , @RequestParam String uclass){
        User user = userService.registService(uname , nickname , password , grade , umajor , uclass);
        if(user!=null){
            HashMap<Integer , String> result = new HashMap<>();
            result.put(0 , "注册成功！");
            return result;
        }
        else{
            HashMap<Integer , String> result = new HashMap<>();
            result.put(1 , "用户已存在！");
            return result;
        }
    }

    @PostMapping("/changePassword")
    public HashMap<Integer , String> changePasswordController(@RequestParam long uid , @RequestParam String oldPassword , @RequestParam String newPassword){
        User user = userService.changePasswordService(uid , oldPassword , newPassword);
        if(user!=null){
            HashMap<Integer , String> result = new HashMap<>();
            result.put(0 , "更改密码成功！");
            return result;
        }
        else{
            HashMap<Integer , String> result = new HashMap<>();
            result.put(1 , "旧密码不匹配！");
            return result;
        }
    }

    @PostMapping("/changeInformation")
    public HashMap<Integer , String> changeInformationService(@RequestParam long uid , @RequestParam String newYear , @RequestParam String newMajor , @RequestParam String newClass , @RequestParam String newNickname){
        User user = userService.changeInformationService(uid , newYear , newMajor , newClass , newNickname);
        if(user!=null){
            HashMap<Integer , String> result = new HashMap<>();
            result.put(0 , "修改资料成功！");
            return result;
        }
        else{
            HashMap<Integer , String> result = new HashMap<>();
            result.put(0 , "资料没有变更！");
            return result;
        }
    }
    @PostMapping("/users")//后台管理账户列表
    public LinkedHashMap<Long , Vector<String>> userListService(@RequestParam int page){
        List<User> userList = userService.userListService();
        LinkedHashMap<Long , Vector<String>> result = new LinkedHashMap<>();
        for(int i=(page-1)*8;i<(page*8)&&i<userList.size();i++){
            Vector<String> info = new Vector<>();
            info.add(userList.get(i).getUname());
            info.add(userList.get(i).getNickname());
            info.add(userList.get(i).getGrade());
            info.add(userList.get(i).getUmajor()+userList.get(i).getUclass()+"班");
            if(userList.get(i).getBaned() == true){
                info.add("封禁中");
            }
            else{
                info.add("正常");
            }
            result.put(userList.get(i).getUid() , info);
        }
        return result;
    }

    @PostMapping("/users/ban")//后台封禁用户
    public HashMap<Integer , String> banUserService(@RequestParam String uname , @RequestParam boolean ban){
        userService.banUserService(uname , ban);
        HashMap<Integer , String> result = new HashMap<>();
        result.put(0 , "更改用户状态成功！");
        return result;
    }

    @PostMapping("/classSelect/classUserList")//前台搜索班级班级同学列表,前台多判断在不在这个班级中
    public LinkedHashMap<String , String> classSelectUserList(@RequestParam long uid , @RequestParam String umajor , @RequestParam String grade , @RequestParam String uclass){
        String inOrNot = userService.classUserInOrNotService(umajor , grade, uclass , uid);
        List<uClass> userList = userService.classListService(umajor , grade , uclass);
        LinkedHashMap<String , String> result = new LinkedHashMap<>();
        result.put("inOrNot" , inOrNot);
        result.put("count" , Integer.toString(userList.size()));
        for(int i=0;i<userList.size();i++){
            result.put(  userList.get(i).getSno(), userList.get(i).getRealname());
        }
        return result;//返回该学生在不在班级里,学生个数,学号姓名
    }

    @PostMapping("/classSelect/classUserList/information")
    public LinkedHashMap<String , String> informationService(@RequestParam String sno){
        User user = userService.informationService(sno);
        LinkedHashMap<String , String> result = new LinkedHashMap<>();
        result.put("nickname" , user.getNickname());
        result.put("uname" , user.getUname());
        result.put("grade" , user.getGrade());
        result.put("umajor" , user.getUmajor());
        result.put("uclass" , user.getUclass());
        return result;
    }

    @PostMapping("/classSelect/classUserList/join")//前台加入班级
    public HashMap<Integer , String> classSelectJoin(@RequestParam String umajor ,@RequestParam String grade ,@RequestParam String uclass , @RequestParam long uid , @RequestParam String sno , @RequestParam String realname){
        boolean classUser= userService.classJoinService(umajor , grade , uclass , uid , sno , realname);
        if(classUser==true){
            HashMap<Integer , String> result = new HashMap<>();
            result.put(0 , "加入班级成功！");
            return result;
        }
        else{
            HashMap<Integer , String> result = new HashMap<>();
            result.put(1 , "学号已经存在！");
            return result;
        }
    }

    @PostMapping("/manager/classUserList")//后台班级管理班级同学列表
    public LinkedHashMap<String , String>  managerClassUserList(@RequestParam String umajor , @RequestParam String grade , @RequestParam String uclass){
        List<uClass> userList = userService.classListService(umajor , grade , uclass);
        LinkedHashMap<String , String> result = new LinkedHashMap<>();
        result.put("count" , Integer.toString(userList.size()));
        for(int i=0;i<userList.size();i++){
            result.put(userList.get(i).getSno() , userList.get(i).getRealname());
        }
        return result;//返回学生个数接着是学号姓名
    }

    @PostMapping("manager/classUserList/out")//后台班级管理踢出成员
    public HashMap<Integer , String> managerClassUserOut(@RequestParam String sno){
        userService.classOutService(sno);
        HashMap<Integer , String> result = new HashMap<>();
        result.put(0 , "已将该用户踢出班级！");
        return result;
    }
}
