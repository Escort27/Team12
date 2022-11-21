package com.example.team12.service.Impl;

import com.example.team12.bean.httpzhibo;
import com.example.team12.dao.streamlineMapper;
import com.example.team12.service.HttpInsertService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class Httpinsertservicelmpl implements HttpInsertService {
    @Autowired
    private streamlineMapper streamlinemapper;


    @Override
    public int addStreamline(String website, String site) {
        httpzhibo zb=new httpzhibo();
        zb.setWebsite(website);
        zb.setSite(site);
        return streamlinemapper.add(zb);
    }
}
