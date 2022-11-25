package com.Team12.YQdemo.repository数据访问层包或叫dao包;
import com.Team12.YQdemo.bean实体类包.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByUid(long uid);
    User findByUname(String uname); //通过uname查找用户，注意要按照JPA的格式使用驼峰命名法
    User findByUnameAndPassword(String uname, String password);//通过uname和密码查找用户
    List<User> findAllByUmajorAndGradeAndUclassAndInclass(String umajor , String grade , String uclass , boolean inclass);

    User findBySno(String sno);

}