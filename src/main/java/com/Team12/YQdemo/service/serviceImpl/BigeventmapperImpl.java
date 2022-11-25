package com.Team12.YQdemo.service.serviceImpl;

import com.Team12.YQdemo.bean.Bigevent;
import com.Team12.YQdemo.dao.BigeventtMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BigeventmapperImpl  {
    @Resource
    private BigeventtMapper bigeventtMapper;

    public List<Bigevent> bigeventselect(int x){
        return bigeventtMapper.query(x);
    }


}
