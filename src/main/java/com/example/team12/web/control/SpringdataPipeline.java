package com.example.team12.web.control;

import com.example.team12.bean.Bigevent;
import com.example.team12.service.BigeventService;
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
