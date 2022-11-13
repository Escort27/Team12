package com.example.team12.logindemo.service存放业务逻辑接口;

import com.example.team12.logindemo.domain存放实体类.User;

public interface UserService {
    /**
     * 登录业务逻辑
     * @param id 账号
     * @param password 密码
     * @return
     */
    User loginService(String id, String password);

    /**
     * 注册业务逻辑
     * @param user 要注册的User对象，属性中主键uid要为空，若uid不为空可能会覆盖已存在的user
     * @return
     */
    User registService(User user);
}