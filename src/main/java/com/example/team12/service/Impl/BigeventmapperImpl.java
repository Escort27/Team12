package com.example.team12.service.Impl;

import com.example.team12.bean.Bigevent;
import com.example.team12.dao.BigeventtMapper;
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
