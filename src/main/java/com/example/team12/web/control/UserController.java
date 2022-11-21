package com.example.team12.web.control;

import com.example.team12.bean.User;
import com.example.team12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cr
 * &#064;date   2022/11/11
 */
@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;
    //表明这是一个get类型的请求
    @GetMapping("query")
    public List<User> query(){
        return userService.query();
    }
}
