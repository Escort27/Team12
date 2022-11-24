package com.Team12.YQdemo.domain实体类包;

import javax.persistence.*;

@Table(name = "user")
@Entity
public class User {

    // 注意属性名要与数据表中的字段名一致
    // 属性varchar对应String
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;

    private String uname;

    private String password;

    private String nickname;

    private String grade;

    private String umajor;


    private String uclass;

    private Boolean baned;

    private String avatar;

    private boolean inclass;

    private String sno;

    private String realname;

    private String createtime;

    public User(){}

    public User(String uname , String nickname , String password , String grade , String umajor , String uclass){
        this.uname=uname;
        this.nickname=nickname;
        this.password=password;
        this.grade=grade;
        this.umajor=umajor;
        this.uclass=uclass;
    }

    public String getSno() {
        return sno;
    }


    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public boolean isInclass() {
        return inclass;
    }

    public void setInclass(boolean inclass) {
        this.inclass = inclass;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public Boolean getBaned() {
        return baned;
    }

    public void setBaned(Boolean baned) {
        this.baned = baned;
    }


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public String getUmajor() {
        return umajor;
    }

    public void setUmajor(String umajor) {
        this.umajor = umajor;
    }


    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getUclass() {
        return uclass;
    }

    public void setUclass(String uclass) {
        this.uclass = uclass;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String creattime) {
        this.createtime = creattime;
    }
    public long getUid() {
        return uid;
    }
    public void setUid(long uid) {
        this.uid = uid;
    }

}