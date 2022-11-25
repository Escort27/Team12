package com.Team12.YQdemo.controller控制层包;

import com.Team12.YQdemo.domain实体类包.User;
import com.Team12.YQdemo.domain实体类包.uClass;
import com.Team12.YQdemo.service业务逻辑接口包.UserService;
import com.Team12.YQdemo.utils存放工具类.UserResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @PostMapping("/login")
    public UserResult<User> loginController(@RequestBody HashMap<String , String> map){
        String uname,password;
        uname = map.get("uname");
        password = map.get("password");
        User user = userService.loginService(uname, password);
        if(user!=null){
            if(user.getBaned() == true){
                return UserResult.error("2","账号已被封禁!");
            }
            else{
                return UserResult.success(user , "登录成功!");//登录成功
            }
        }else{
            return UserResult.error("1","用户未注册或账号密码错误！");
        }
    }

    @PostMapping("/register")
    public HashMap<String , String> registController(@RequestBody HashMap<String , String> map){
        String uname,nickname,password,grade,umajor,uclass;
        uname = map.get("uname");
        nickname = map.get("nickname");
        password = map.get("password");
        grade = map.get("grade");
        umajor = map.get("umajor");
        uclass = map.get("uclass");
        User user = userService.registService(uname , nickname , password , grade , umajor , uclass);
        if(user!=null){
            HashMap<String , String> result = new HashMap<>();
            result.put("result" , "0");//注册成功
            return result;
        }
        else{
            HashMap<String, String> result = new HashMap<>();
            result.put("result" , "1");//用户已存在
            return result;
        }
    }

    @PostMapping("/changePassword")
    public HashMap<String , String> changePasswordController(@RequestBody HashMap<String , String> map){
        String uid , oldPassword , newPassword;
        uid = map.get("uid");
        oldPassword = map.get("oldPassword");
        newPassword = map.get("newPassword");
        long id = Long.parseLong(uid);
        User user = userService.changePasswordService(id , oldPassword , newPassword);
        if(user!=null){
            HashMap<String , String> result = new HashMap<>();
            result.put("result" , "0");//更改密码成功
            return result;
        }
        else{
            HashMap<String , String> result = new HashMap<>();
            result.put("result" , "1");//旧密码不匹配
            return result;
        }
    }

    @PostMapping("/changeInformation")
    public HashMap<String , String> changeInformationController(@RequestBody HashMap<String , String> map){
        String uid , newGrade , newMajor , newClass , newNickname , newAvatar;
        uid = map.get("uid");
        newGrade = map.get("newGrade");
        newMajor = map.get("newMajor");
        newClass = map.get("newClass");
        newNickname = map.get("newNickname");
        newAvatar = map.get("newAvatar");
        long id = Long.parseLong(uid);
        User user = userService.changeInformationService(id , newGrade , newMajor , newClass , newNickname , newAvatar);
        if(user!=null){
            HashMap<String , String> result = new HashMap<>();
            result.put("result" , "0");//修改资料成功
            return result;
        }
        else{
            HashMap<String , String> result = new HashMap<>();
            result.put("result" , "1");//资料没有变更
            return result;
        }
    }
    @PostMapping("/users")//后台管理账户列表
    public LinkedHashMap<String , String> userListController(@RequestBody HashMap<String , Integer> map){
        int page = map.get("page");
        List<User> userList = userService.userListService();
        LinkedHashMap<String , String> result = new LinkedHashMap<>();
        result.put("count" , Integer.toString(userList.size()));
        for(int i=(page-1)*8,j=0;i<(page*8)&&i<userList.size();i++,j++){
            j=j%8;
            result.put("uid"+j , Long.toString(userList.get(i).getUid()));
            result.put("uname"+j , userList.get(i).getUname());
            result.put("nickname"+j , userList.get(i).getNickname());
            result.put("grade"+j , userList.get(i).getGrade());
            result.put("umajor"+j , userList.get(i).getUmajor());
            result.put("uclass"+j , userList.get(i).getUclass());
            result.put("createTime"+j , userList.get(i).getCreatetime());
            if(userList.get(i).getBaned() == true){
                result.put("ban"+j , "封禁中");
            }
            else{
                result.put("ban"+j , "正常");
            }
        }
        return result;
    }

    @PostMapping("/users/ban")//后台封禁用户
    public HashMap<String  , String> banUserController(@RequestBody HashMap<String , String> map){
        String uname,ban;
        uname = map.get("uname");
        ban = map.get("ban");//ban的值为"true"或"false"
        userService.banUserService(uname , Boolean.parseBoolean(ban));
        HashMap<String , String> result = new HashMap<>();
        result.put("result" , "0");//更改用户状态成功！
        return result;
    }

    @PostMapping("/classSelect/classUserList")//前台搜索班级班级同学列表,前台多判断在不在这个班级中
    public LinkedHashMap<String , String> classSelectUserListController(@RequestBody HashMap<String , String> map){
        String uid = map.get("uid");
        String umajor = map.get("umajor");
        String grade = map.get("grade");
        String uclass = map.get("uclass");
        long id = Long.parseLong(uid);
        String inOrNot = userService.classUserInOrNotService(umajor , grade, uclass , id);
        List<uClass> userList = userService.classListService(umajor , grade , uclass);
        LinkedHashMap<String , String> result = new LinkedHashMap<>();
        result.put("inOrNot" , inOrNot);
        result.put("count" , Integer.toString(userList.size()));
        for(int i=0;i<userList.size();i++){
            result.put("sno"+i , userList.get(i).getSno());
            result.put("realname"+i  , userList.get(i).getRealname());
            result.put("avatar"+i , userService.findSomeone(userList.get(i).getUid()).getAvatar());
        }
        return result;//返回该学生在不在班级里,学生个数,学号姓名
    }

    @PostMapping("/classSelect/classUserList/information")
    public LinkedHashMap<String , String> informationServiceController(@RequestBody HashMap<String , String> map){
        String sno = map.get("sno");
        User user = userService.informationService(sno);
        LinkedHashMap<String , String> result = new LinkedHashMap<>();
        result.put("avatar" , user.getAvatar());
        result.put("nickname" , user.getNickname());
        result.put("uname" , user.getUname());
        result.put("grade" , user.getGrade());
        result.put("umajor" , user.getUmajor());
        result.put("uclass" , user.getUclass());
        return result;
    }

    @PostMapping("/classSelect/classUserList/join")//前台加入班级
    public HashMap<String , String> classSelectJoinController(@RequestBody HashMap<String , String> map){
        String umajor ,grade , uclass , uid , sno , realname;
        umajor = map.get("umajor");
        uclass = map.get("uclass");
        grade = map.get("grade");
        uid = map.get("uid");
        sno = map.get("sno");
        realname = map.get("realname");
        long id = Long.parseLong(uid);
        boolean classUser= userService.classJoinService(umajor , grade , uclass , id , sno , realname);
        if(classUser==true){
            HashMap<String , String> result = new HashMap<>();
            result.put("result" , "0");//加入班级成功！
            return result;
        }
        else{
            HashMap<String , String> result = new HashMap<>();
            result.put("result" , "1");//学号已经存在！
            return result;
        }
    }

    @PostMapping("/manager/classUserList")//后台班级管理班级同学列表
    public LinkedHashMap<String , String>  managerClassUserListController(@RequestBody HashMap<String , String> map){
        String umajor , grade , uclass;
        umajor = map.get("umajor");
        grade = map.get("grade");
        uclass = map.get("uclass");
        List<uClass> userList = userService.classListService(umajor , grade , uclass);
        LinkedHashMap<String , String> result = new LinkedHashMap<>();
        result.put("count" , Integer.toString(userList.size()));
        for(int i=0;i<userList.size();i++){
            result.put("sno"+i , userList.get(i).getSno());
            result.put("realname"+i , userList.get(i).getRealname());
        }
        return result;//返回学生个数接着是学号姓名
    }

    @PostMapping("manager/classUserList/out")//后台班级管理踢出成员
    public HashMap<String , String> managerClassUserOutController(@RequestBody HashMap<String , String> map){
        String sno = map.get("sno");
        userService.classOutService(sno);
        HashMap<String , String> result = new HashMap<>();
        result.put("result" , "0");//已将该用户踢出班级！
        return result;
    }
}
