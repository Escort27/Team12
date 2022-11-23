package com.example.team12.dao;

import com.example.team12.bean.campus_scenery;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface sceneryMapper {

    @Select("select * from campus_scenery order by thumbs_up DESC LIMIT 5")
    List<campus_scenery> refresh_five();//排行榜  url+点赞

    @Select("select * from campus_scenery ")
    List<campus_scenery> refresh_all();//后台全部

    //@Select("select * from campus_scenery ")



//    @Select("select pic_url from campus_scenery order by thumbs_up DESC LIMIT 5")
//    List<campus_scenery> refresh();



    @Insert("insert into campus_scenery(pic_url) values(#{pic_url})")
    int upload_pic(@Param("pic_url") String pic_url);

    @Update("update campus_scenery set thumbs_up=#{thumbs_up} where pic_url=#{pic_url}")
    int give_a_like(@RequestParam ("pic_url") String pic_url,@RequestParam("thumbs_up") int thumbs_up);

//    @Update("update campus_scenery set thumbs_up=thumbs_up+1 where pic_url=#{pic_url}")

    @Delete("delete from campus_scenery where pic_url=#{pic_url}")
    int deny(@Param("pic_url") String pic_url);

}
