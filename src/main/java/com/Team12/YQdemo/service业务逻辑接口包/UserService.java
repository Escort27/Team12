package com.Team12.YQdemo.service业务逻辑接口包;

import com.Team12.YQdemo.domain实体类包.User;

public interface UserService {

    User loginService(String uname, String password);

    User registService(User user);

    User changePasswordService(String uname , String oldPassword , String newPassword);

    User changeInformationService(String uname , int newyear , String newmajor , int newClass , String newNickname );

}