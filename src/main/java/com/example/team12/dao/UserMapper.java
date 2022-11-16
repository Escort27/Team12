package com.example.team12.dao;

import com.example.team12.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author cr
 * &#064;date   2022/11/11
 * 使用注解方式进行数据库查询
 */
public interface UserMapper {
    @Select("select sno,sname,sage,ssex from student")
    List<User> query();
}
