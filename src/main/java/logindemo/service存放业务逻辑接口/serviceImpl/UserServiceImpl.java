package logindemo.service存放业务逻辑接口.serviceImpl;

import logindemo.domain存放实体类.User;
import logindemo.repository存放一些数据访问类.UserDao;
import logindemo.service存放业务逻辑接口.UserService;

import javax.annotation.Resource;

public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Override
    public User loginService(String id, String password) {
        //如果账号和密码都对则返回登录的用户对象，若有一个错误则返回null
        User user = userDao.findByIDAndPassword(id, password);
        return user;
    }

    @Override
    public User registService(User user) {
        //当用户的用户名已经存在时
        if(userDao.findByID(user.getName())!=null){
            //无法注册
            return null;
        }
        else{
            //返回创建好的用户对象
            User newUser = userDao.save(user);
            return newUser;
        }
    }
}
