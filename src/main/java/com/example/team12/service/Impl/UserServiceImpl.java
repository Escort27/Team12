package com.example.team12.service.Impl;

import com.example.team12.bean.User;
import com.example.team12.dao.UserMapper;
import com.example.team12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cr
 * &#064;date   2022/11/11
 * UserService的具体实现类
 */
@Service
public class UserServiceImpl implements UserService {
    //调用UserMapper查询数据
    //@Resource或者@Autowired注解都可
    @Resource
    //@Autowired
    private UserMapper userMapper;

    @Override
    public List<User> query() {
        //调用UserMapper中的query方法，返回一个List，类型为User
        return userMapper.query();
    }
}
