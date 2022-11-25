package com.Team12.YQdemo.service.serviceImpl;

import com.Team12.YQdemo.bean.Bigevent;
import com.Team12.YQdemo.dao.BigeventInsert;
import com.Team12.YQdemo.service.BigeventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BigeventserviceImpl implements BigeventService {

    @Autowired
    private BigeventInsert bigeventInsert;


    @Override
    public void save(Bigevent bigevent) {
        //查询原有数据
        Bigevent param =new Bigevent();
        param.setLink(bigevent.getLink());
        param.setDate(bigevent.getDate());
        //执行查询
        List<Bigevent> list=this.findBigevent(param);
        //判断数据库中是否有已存在数据
        if (list.size()==0){
            this.bigeventInsert.saveAndFlush(bigevent);

        }
    }

    @Override
    public List<Bigevent> findBigevent(Bigevent bigevent) {
        //查询条件
        Example example=Example.of(bigevent);
        //执行查询
        List list=this.bigeventInsert.findAll(example);
        return list;
    }
}
