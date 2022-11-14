package com.Team12.demo.service业务逻辑接口包.serviceImpl业务逻辑实现包;

import com.Team12.demo.repository数据访问层包或叫dao包.UserDao;
import com.Team12.demo.service业务逻辑接口包.UserService;
import com.Team12.demo.domain实体类包.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User loginService(String uname, String password) {
        // 如果账号密码都对则返回登录的用户对象，若有一个错误则返回null
        User user = userDao.findByUnameAndPassword(uname, password);
        return user;
    }
    @Override
    public User registService(User user) {
        //当新用户用户名已存在时
        if(userDao.findByUname(user.getUname())!=null){
            // 无法注册
            return null;
        }
        else{
            //返回创建好的用户对象
            User newUser = userDao.save(user);
            return newUser;
        }
    }
}