package com.team12.YQdemo.service.serviceImpl;

import com.team12.YQdemo.bean.httpzhibo;
import com.team12.YQdemo.dao.HttpMapper;
import com.team12.YQdemo.service.HttpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HttpServicelmpl implements HttpService {

    @Resource
    private HttpMapper httpMapper;


    @Override
    public String httpquery() {
        return httpMapper.query();
    }

    @Override
    public List<httpzhibo> zhiboquery(){
        return httpMapper.query2();
    }
}
