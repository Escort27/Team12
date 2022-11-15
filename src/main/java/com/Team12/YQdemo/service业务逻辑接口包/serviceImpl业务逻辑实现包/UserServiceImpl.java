package com.Team12.YQdemo.service业务逻辑接口包.serviceImpl业务逻辑实现包;

import com.Team12.YQdemo.repository数据访问层包或叫dao包.UserDao;
import com.Team12.YQdemo.service业务逻辑接口包.UserService;
import com.Team12.YQdemo.domain实体类包.User;
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
            //发现数据库中baned设置默认值0，用户注册完，baned的值为null，并没有设置为0,所以加上下面语句
            user.setBaned(false);
            User newUser = userDao.save(user);
            return newUser;
        }
    }

    @Override
    public User changePasswordService(String uname , String oldPassword , String newPassword) {
        User user = userDao.findByUname(uname);
        if(user.getPassword().equals(oldPassword)){
            user.setPassword(newPassword);
            userDao.save(user);
            return user;
        }
        else{
            return null;
        }
    }

    @Override
    public User changeInformationService(String uname , int newyear , String newmajor , int newClass , String newNickname ){
        User user = userDao.findByUname(uname);
//        if(newNickname != null) {
//            user.setNickname(newNickname);
//        }
//        if(newyear != null){
//            user.setYearOfGraduate(newyear);
//        }

    }
}