package com.Team12.demo.service业务逻辑接口包;

import com.Team12.demo.domain实体类包.User;

public interface UserService {

    User loginService(String uname, String password);

    User registService(User user);

    User changePasswordService(String uname , String oldPassword , String newPassword);

}