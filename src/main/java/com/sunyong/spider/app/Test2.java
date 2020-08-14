package com.sunyong.spider.app;


import com.sunyong.spider.handller.SpiderUtil;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

public class Test2 {


    public static void main(String[] args) {

        Spider.create(new SpiderUtil()).addUrl("http://www.hotelaah.com/huoche/yantai.html").addPipeline(new ConsolePipeline())
                .run();


        System.out.println(SpiderUtil.spiderlist);
    }
}
