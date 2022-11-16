package com.Team12.YQdemo.service业务逻辑接口包;

import com.Team12.YQdemo.domain实体类包.User;

import java.util.List;

public interface UserService {

    User loginService(String uname, String password);//登录

    User registService(User user);//注册

    User changePasswordService(String uname , String oldPassword , String newPassword);//修改密码

    User changeInformationService(String uname , int newYear , String newMajor , int newClass , String newNickname );//修改资料

    List<User> userListService();//后台返回账号列表

    User banUserService(String uname , boolean ban);//后台封禁解封账号

    List<User> classListService(String umajor , int grade , int uclass);//返回班级同学列表（前后台共用）

    User classJoinService (String uname , String realname , String sno);//加入班级

    User classOutService (String sno);//后台踢出班级成员
}