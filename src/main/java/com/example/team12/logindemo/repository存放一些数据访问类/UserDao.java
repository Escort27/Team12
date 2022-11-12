package com.example.team12.logindemo.repository存放一些数据访问类;

import com.example.team12.logindemo.domain存放实体类.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByUname(String name); //通过用户名uname查找用户，注意要按照JPA的格式使用驼峰命名法
    User findByUnameAndPassword(String name, String password);//通过用户名uname和密码查找用户
}
