package com.Team12.YQdemo.service业务逻辑接口包.serviceImpl业务逻辑实现包;

import com.Team12.YQdemo.bean实体类包.User;
import com.Team12.YQdemo.bean实体类包.uClass;
import com.Team12.YQdemo.repository数据访问层包或叫dao包.ClassDao;
import com.Team12.YQdemo.repository数据访问层包或叫dao包.UserDao;
import com.Team12.YQdemo.service业务逻辑接口包.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private ClassDao classDao;


    @Override
    public User loginService(String uname, String password) {
        // 如果账号密码都对则返回登录的用户对象，若有一个错误则返回null
        User user = userDao.findByUnameAndPassword(uname, password);
        return user;
    }
    @Override
    public User registService(String uname , String nickname , String password , String grade , String umajor , String uclass) {
        //当新用户用户名已存在时
        if(userDao.findByUname(uname)!=null){
            // 无法注册
            return null;
        }
        else{
            //返回创建好的用户对象
            //发现数据库中baned设置默认值0，用户注册完，baned的值为null，并没有设置为0,所以加上下面语句
            User user = new User(uname,nickname,password,grade,umajor,uclass);
            user.setBaned(false);//新注册用户肯定没有给封禁
            user.setInclass(false);//新注册用户肯定没有加入班级组织
            user.setAvatar("");
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());
            user.setCreatetime(formatter.format(date));
            User newUser = userDao.save(user);
            return newUser;
        }
    }

    @Override
    public User changePasswordService(long uid , String oldPassword , String newPassword) {
        User user = userDao.findByUid(uid);
        //比对输入的旧密码是否匹配
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
    public User changeInformationService(long uid , String newGrade , String newMajor , String newClass , String newNickname , String newAvatar){
        User user = userDao.findByUid(uid);
        boolean flag = false;//有一项修改了，信息就有改变，传过来的数据有用并且和源数据不一样，才修改
        if(!newNickname.equals("") && !user.getNickname().equals(newNickname)) {
                user.setNickname(newNickname);
                flag = true;
        }
        if(!newGrade.equals("") && !user.getGrade().equals(newGrade)){
            user.setGrade(newGrade);
            flag = true;
        }
        if(!newMajor.equals("") && !user.getUmajor().equals(newMajor)){
            user.setUmajor(newMajor);
            flag = true;
        }
        if(!newClass.equals("") && !user.getUclass().equals(newClass)){
            user.setUclass(newClass);
            flag = true;
        }
        if(!newAvatar.equals("") && !user.getAvatar().equals(newAvatar)){
            user.setAvatar(newAvatar);
            flag = true;
        }
        if(flag){
            userDao.save(user);
            return user;
        }
        else{
            return null;
        }
    }
    @Override
    public List<User> userListService() {
        List<User> userList = userDao.findAll();
        return userList;
    }
    @Override
    public void banUserService(String uname , boolean ban) {
        User user = userDao.findByUname(uname);
        user.setBaned(ban);
        userDao.save(user);
    }
    @Override
    public String classUserInOrNotService(String umajor , String grade , String uclass , long uid) {
        if(classDao.findByUmajorAndGradeAndUclassAndUid(umajor,grade,uclass,uid)==null){
            return "not";//不在班级中
        }
        else{
            return "in";//在班级中
        }
    }
    @Override
    public List<uClass> classListService(String umajor , String grade , String uclass) {
        List<uClass> ClassUserList = classDao.findAllByUmajorAndGradeAndUclass(umajor , grade , uclass );
        return ClassUserList;
    }
    @Override
    public boolean classJoinService(String umajor , String grade , String uclass , long uid , String sno , String realname) {
        User user = userDao.findByUid(uid);
        if(userDao.findBySno(sno)==null) {
            user.setSno(sno);
        }
        else{
            if(uid!=userDao.findBySno(sno).getUid()){
                return false;//学号已经存在
            }
        }
        user.setRealname(realname);
        userDao.save(user);
        uClass classUser = new uClass(umajor , grade , uclass , uid , sno , realname);
        classDao.save(classUser);
        return true;//加入成功
    }
    @Override
    public void classOutService(String umajor , String grade , String uclass , String sno) {
        classDao.deleteByUmajorAndGradeAndUclassAndSno(umajor,grade,uclass,sno);
    }

    @Override
    public User informationService(String sno){
        User user = userDao.findBySno(sno);
        return user;
    }

    @Override
    public User findSomeone(long uid){
        User user = userDao.findByUid(uid);
        return user;
    }
}