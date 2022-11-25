package com.Team12.YQdemo.service;

import com.Team12.YQdemo.bean.Bigevent;

import java.util.List;

public interface BigeventService {
    public void save(Bigevent bigevent);
    public List<Bigevent> findBigevent(Bigevent bigevent);
}
