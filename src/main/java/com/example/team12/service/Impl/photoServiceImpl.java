package com.example.team12.service.Impl;

import com.example.team12.bean.back_photo;
import com.example.team12.dao.pictureMapper;
import com.example.team12.service.pictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class photoServiceImpl implements pictureService {

    @Resource
    private pictureMapper picturemapper;

    @Override
    public String getimg_path(String user_name){
        return picturemapper.getimg_path(user_name);
    }
}
