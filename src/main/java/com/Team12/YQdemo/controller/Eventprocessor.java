package com.Team12.YQdemo.controller;

import com.Team12.YQdemo.bean.Bigevent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;
@CrossOrigin
@Component
public class Eventprocessor implements PageProcessor {
    private String url="https://ccds.fzu.edu.cn/xwzx/xytz.htm";

    @Override
    public void process(Page page) {
        List<Selectable> list= page.getHtml().xpath("/html/body/div[6]/div[2]/div[5]/div[1]/dl/dd*/a[2]").nodes();//
        if (list.size()==0){
            this.savebigevent(page);
        }else {
            for (Selectable selectable : list) {
                String newsurl = selectable.links().toString();
                page.addTargetRequest(newsurl);
            }
        }
        String bkurl=page.getHtml().css("div.pb_sys_common.pb_sys_full.pb_sys_style2 span.p_pages span.p_next.p_fun").links().toString();
        page.addTargetRequest(bkurl);

    }

    private void savebigevent(Page page) {
        Bigevent bigevent=new Bigevent();
        Html html=page.getHtml();
        bigevent.setLink(page.getUrl().toString());
        bigevent.setTitle(html.css("div.container_right_title2 h3","text").toString());
        String str = html.css("div.container_right_title2 p","text").toString();
        str = str.trim();
        String str2 = "";
        if(str != null && !"".equals(str)){
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) >= 48 && str.charAt(i) <= 57){
                    str2 += str.charAt(i);
                }
            }
        }
        bigevent.setDate(str2);
        page.putField("bigevent",bigevent);
    }


    private  Site site=Site.me()
            .setCharset("utf8")//设置编码
            .setTimeOut(10*1000)//设置超时时间
            .setRetrySleepTime(3000)//设置重试时间
            .setRetryTimes(3);//设置重试次数
    @Override
    public Site getSite() {
        return site;
    }
    @Autowired
    private SpringdataPipeline springdataPipeline;

    @Scheduled(initialDelay = 1000,fixedDelay = 86400*1000)//每24h执行一次
    public void process(){
        Spider.create(new Eventprocessor())
                .addUrl(url)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(1000)))
                .thread(10)
                .addPipeline(springdataPipeline)
                .run();
    }
}
