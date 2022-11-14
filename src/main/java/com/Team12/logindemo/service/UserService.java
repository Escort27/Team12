package com.Team12.logindemo.service;

import com.Team12.logindemo.domain.User;

public interface UserService {

    User loginService(String uname, String password);

    User registService(User user);
}