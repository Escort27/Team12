package com.team12.YQdemo.dao;

import com.team12.YQdemo.bean.httpzhibo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HttpMapper {
    @Select("select website from streamline order by data DESC limit 0,1")/* 数据库中data对应字段属性为datetime 默认值为CURRENT_TIMESTAMP */
    public String query();

    @Select("select website,site from streamline order by data DESC limit 0,1")
    public List<httpzhibo> query2();
}
