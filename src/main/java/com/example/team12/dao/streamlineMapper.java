package com.example.team12.dao;

import com.example.team12.bean.httpzhibo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface streamlineMapper {
    @Insert({"insert into streamline(website,site) values('${streamline.website}','${streamline.site}')"})
    int add(@Param("streamline")httpzhibo streamline);//类+table name
}
