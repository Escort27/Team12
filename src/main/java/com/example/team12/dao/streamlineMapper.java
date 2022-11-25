package com.example.team12.dao;

import com.example.team12.bean.httpzhibo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface streamlineMapper {
    @Insert({"insert into streamline(website,site) values(#{website},#{site})"})
    Integer add(@Param("website") String website, @Param("site") String site);//类+table name
}
