package com.example.team12.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Mapper
@Data//lombok
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "streamline")//数据库表名
public class httpzhibo {
    @Id
    @KeySql(useGeneratedKeys = true)
    private String website;
    private String site;

    public void setSite(String site) {
        this.site = site;
    }


    public void setWebsite(String website) {
        this.website = website;
    }


    public String getSite() {
        return site;
    }

    public String getWebsite() {
        return website;
    }



}
