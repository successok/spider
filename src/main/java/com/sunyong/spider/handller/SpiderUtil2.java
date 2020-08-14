package com.sunyong.spider.handller;

import com.sunyong.spider.entry.TaskInfo;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

public class SpiderUtil2 implements PageProcessor {

    public static TaskInfo spiderlist;

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);


    @Override
    public void process(Page page) {


        Selectable last_time = page.getHtml().xpath("//html/body/div[2]/table[3]/tbody/tr[1]/td[1]/a/text()");
        Selectable input_size = page.getHtml().xpath("//html/body/div[2]/table[3]/tbody/tr[1]/td[2]/a/text()");
        Selectable scheduling_delay = page.getHtml().xpath("//html/body/div[2]/table[3]/tbody/tr[1]/td[3]/a/text()");
        Selectable processing_time = page.getHtml().xpath("//html/body/div[2]/table[3]/tbody/tr[1]/td[4]/a/text()");
        Selectable total_delay = page.getHtml().xpath("//html/body/div[2]/table[3]/tbody/tr[1]/td[5]/text()");


        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setLast_batch_time(last_time.toString());
        taskInfo.setInput_size(input_size.toString());
        taskInfo.setScheduling_delay(scheduling_delay.toString());
        taskInfo.setProcessing_time(processing_time.toString());
        taskInfo.setTotal_delay(total_delay.toString());

        spiderlist = taskInfo;


//        page.putField("task", taskInfo);


    }

    @Override
    public Site getSite() {
        return site;
    }
}
