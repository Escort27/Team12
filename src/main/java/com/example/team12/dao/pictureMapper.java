package com.example.team12.dao;

import com.example.team12.bean.back_photo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface pictureMapper {

    @Select("select virtual_combination from virtual_photo where user_name = #{user_name}")
    String getimg_path(@RequestParam("user_name")String user_name);
}
