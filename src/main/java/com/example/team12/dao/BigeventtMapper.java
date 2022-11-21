package com.example.team12.dao;

import com.example.team12.bean.Bigevent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BigeventtMapper {
    @Select("select title,link,date from bigevent order by date DESC limit #{x},10")
    public List<Bigevent> query(@Param("x") int x);

}
