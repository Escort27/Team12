package com.example.team12.logindemo.domain存放实体类;

import javax.persistence.*;

@Table(name = "user")
@Entity
public class User {
    // 注意属性名要与数据表中的字段名一致
    //主键id上要加上@Id与@GeneratedValue(strategy = GenerationType.IDENTITY)注解

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // 用户名属性varchar对应String
    private String name;

    // 密码属性varchar对应String
    private String password;

    private int yearOfGraduation;

    private String major;

    private int classNum;

    //头像先放着

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getYearOfGraduation() {
        return yearOfGraduation;
    }

    public void setYearOfGraduation(int yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }
}