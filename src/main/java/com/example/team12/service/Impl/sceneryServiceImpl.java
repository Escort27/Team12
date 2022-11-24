package com.example.team12.service.Impl;

import com.example.team12.bean.campus_scenery;
import com.example.team12.dao.sceneryMapper;
import com.example.team12.service.sceneryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class sceneryServiceImpl implements sceneryService {

    @Resource
    private sceneryMapper scenerymapper;
    @Override
    public List<campus_scenery> refresh_five() {
        return scenerymapper.refresh_five();
    }

    @Override
    public List<campus_scenery> refresh_all(){
        return scenerymapper.refresh_all();
    }

    @Override
    public int upload_pic(Map map) {
        return scenerymapper.upload_pic((String) map.get("pic_url"));
    }
    @Override
    public void uploadpicservice(String pic_url){
        scenerymapper.uploadpic(pic_url);
    }
    @Override
    public int give_a_like(Map map) {
        return scenerymapper.give_a_like((String) map.get("pic_url"),(int) map.get("thumbs_up"));
    }

    @Override
    public int deny(Map map) {
        return scenerymapper.deny((String) map.get("pic_url"));
    }
}
