package com.Team12.YQdemo.service业务逻辑接口包;
import com.Team12.YQdemo.domain实体类包.User;
import com.Team12.YQdemo.domain实体类包.uClass;
import java.util.List;

public interface UserService {

    User loginService(String uname, String password);//登录

    User registService(String uname , String nickname , String password , String grade , String umajor , String uclass);//注册

    User changePasswordService(long uid , String oldPassword , String newPassword);//修改密码

    User changeInformationService(long uid , String newYear , String newMajor , String newClass , String newNickname );//修改资料

    List<User> userListService();//后台返回账号列表

    User banUserService(String uname , boolean ban);//后台封禁解封账号

    String classUserInOrNotService(String umajor , String grade , String uclass , long uid);
    List<uClass> classListService(String umajor , String grade , String uclass);//返回班级同学列表（前后台共用）

    int classJoinService(String umajor , String grade , String uclass , long uid , String sno , String realname);//加入班级

    User classOutService (String sno);//后台踢出班级成员
}