package com.example.team12.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface sceneryService {

    List<String> refresh_five();
    int upload_pic( Map map);
    int give_a_like(Map map);


    int deny(Map map);
}
