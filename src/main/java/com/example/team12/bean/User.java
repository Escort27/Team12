package com.example.team12.bean;

/**
 * @author cr
 * &#064;date  2022/11/11
 * 示例User类，对应数据库中的id，name，age，gender
 */
public class User {
    private String sno;
    private String sname;
    private Integer sage;
    private String ssex;

    public void setSno(String sno) {
        this.sno = sno;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSno() {
        return sno;
    }

    public String getSname() {
        return sname;
    }

    public Integer getSage() {
        return sage;
    }

    public String getSsex() {
        return ssex;
    }
}
