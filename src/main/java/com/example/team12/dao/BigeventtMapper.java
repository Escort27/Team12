package com.example.team12.dao;

import com.example.team12.bean.Bigevent;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BigeventtMapper {
    @Select("select title,link,date from bigevent order by date DESC limit 0,50")
    List<Bigevent> query();
}
