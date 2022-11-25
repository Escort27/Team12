package com.Team12.YQdemo.bean;

import javax.persistence.*;

@Table(name = "class")
@Entity
public class Uclass {
    // 注意属性名要与数据表中的字段名一致
    // 属性varchar对应String
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long classuid;
    private String sno;
    private String realname;

    private String grade;

    private String umajor;

    private String uclass;

    private long uid;


    public Uclass(){}

    public Uclass(String umajor , String grade , String uclass , long uid , String sno , String realname) {
        this.uid = uid;
        this.sno = sno;
        this.realname = realname;
        this.grade = grade;
        this.umajor = umajor;
        this.uclass = uclass;
    }

    public long getClassuid() {
        return classuid;
    }

    public void setClassuid(long userid) {
        this.classuid = userid;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getUmajor() {
        return umajor;
    }

    public void setUmajor(String umajor) {
        this.umajor = umajor;
    }

    public String getUclass() {
        return uclass;
    }

    public void setUclass(String uclass) {
        this.uclass = uclass;
    }
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }
}