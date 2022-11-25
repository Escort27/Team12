package com.Team12.YQdemo.controller;

import com.Team12.YQdemo.bean.Bigevent;
import com.Team12.YQdemo.service.BigeventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class SpringdataPipeline implements Pipeline {
    @Autowired
    private BigeventService bigeventService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        Bigevent bigevent=resultItems.get("bigevent");
        if (bigevent!=null){
            this.bigeventService.save(bigevent);
        }
    }

}
