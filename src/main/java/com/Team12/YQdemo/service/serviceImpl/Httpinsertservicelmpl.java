package com.Team12.YQdemo.service.serviceImpl;

import com.Team12.YQdemo.dao.streamlineMapper;
import com.Team12.YQdemo.service.HttpInsertService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class Httpinsertservicelmpl implements HttpInsertService {
    @Resource
    private streamlineMapper streamlinemapper;


    @Override
    public int addStreamline(Map map) {
        return streamlinemapper.add((String) map.get("website"),(String) map.get("site"));
    }
}
