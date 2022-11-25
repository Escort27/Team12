package com.example.team12.service;

import com.example.team12.bean.Bigevent;

import java.util.List;

public interface BigeventService {
    public void save(Bigevent bigevent);
    public List<Bigevent> findBigevent(Bigevent bigevent);
}
