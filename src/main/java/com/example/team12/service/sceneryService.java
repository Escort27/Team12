package com.example.team12.service;

import com.example.team12.bean.campus_scenery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface sceneryService {

    List<campus_scenery> refresh_five();
    List<campus_scenery> refresh_all();
    int upload_pic( Map map);
    int give_a_like(Map map);


    int deny(Map map);
}
