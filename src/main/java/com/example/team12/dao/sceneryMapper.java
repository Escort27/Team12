package com.example.team12.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface sceneryMapper {

    @Select("select pic_url from campus_scenery order by thumbs_up DESC LIMIT 5")
    List<String> refresh_five();

    @Insert("insert into campus_scenery(pic_url) values(#{pic_url})")
    int upload_pic(@Param("pic_url") String pic_url);

    @Update("update campus_scenery set thumbs_up=thumbs_up+1 where pic_url=#{pic_url}")
    int give_a_like(@Param("pic_url") String pic_url);

    @Delete("delete from campus_scenery where pic_url=#{pic_url}")
    int deny(@Param("pic_url") String pic_url);

}
