package com.sunyong.spider.handller;

import com.sunyong.spider.entry.TaskInfo;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class SpiderUtil implements PageProcessor {

    public static TaskInfo spiderlist;

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);


    @Override
    public void process(Page page) {


//        Selectable last_time = page.getHtml().xpath("//html/body/div[4]/div[8]/div[2]/ul[1]/li/a/text()");
        Selectable last_time = page.getHtml().css("body > div:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(15) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1)");


        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setLast_batch_time(last_time.toString());


        spiderlist = taskInfo;


//        page.putField("task", taskInfo);


    }

    @Override
    public Site getSite() {
        return site;
    }
}
