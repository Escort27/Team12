package com.Team12.demo.domain实体类包;

import javax.persistence.*;

@Table(name = "user")
@Entity
public class User {
    // 注意属性名要与数据表中的字段名一致
    // 属性varchar对应String
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    private String uname;

    private String password;

    private String nickname;

    private int yearOfGraduate;

    private String umajor;

    private int uclass;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
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

    public int getYearOfGraduate() {
        return yearOfGraduate;
    }

    public void setYearOfGraduate(int yearOfGraduate) {
        this.yearOfGraduate = yearOfGraduate;
    }

    public String getUmajor() {
        return umajor;
    }

    public void setUmajor(String umajor) {
        this.umajor = umajor;
    }

    public int getUclass() {
        return uclass;
    }

    public void setUclass(int uclass) {
        this.uclass = uclass;
    }
}