package com.Team12.YQdemo.service业务逻辑接口包;

import com.Team12.YQdemo.domain实体类包.User;

import java.util.List;

public interface UserService {

    User loginService(String uname, String password);

    User registService(User user);

    User changePasswordService(String uname , String oldPassword , String newPassword);

    User changeInformationService(String uname , int newYear , String newMajor , int newClass , String newNickname );

    User banUserService(String uname , boolean ban);

    List<User> classListService(String umajor , int grade , int uclass);

    User classJoinService (String uname , String realname , String sno);
}