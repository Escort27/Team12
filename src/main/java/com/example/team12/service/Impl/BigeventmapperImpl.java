package com.example.team12.service.Impl;

import com.example.team12.bean.Bigevent;
import com.example.team12.dao.BigeventtMapper;
import com.example.team12.service.BigeventMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BigeventmapperImpl implements BigeventMapperService {
    @Resource
    private BigeventtMapper bigeventtMapper;

    @Override
    public List<Bigevent> query() {
        return bigeventtMapper.query();
    }
}
