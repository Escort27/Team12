package com.example.team12.dao;

import com.example.team12.bean.httpzhibo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HttpMapper {
    @Select("select website,site from streamline order by data DESC limit 0,1")/* 数据库中data对应字段属性为datetime 默认值为CURRENT_TIMESTAMP */
    List<httpzhibo> query();
}
