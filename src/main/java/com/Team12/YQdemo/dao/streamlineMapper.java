package com.Team12.YQdemo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface streamlineMapper {
    @Insert({"insert into streamline(website,site) values(#{website},#{site})"})
    int add(@RequestParam("website") String website, @RequestParam("site") String site);//类+table name
}
