package com.sunyong.spider.app;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test implements PageProcessor {

//    private Site site = Site.me()
//            .setDomain("http://localhost:4040/streaming/")
//            .setSleepTime(1000)
//            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {

        List<String> list = Arrays.asList("所有链","功能");

        for(String str:list){

    //        Selectable html = page.getHtml()("//html/body/div[4]/div[8]/div[2]/ul[1]/li/a/text()");
            Selectable html = page.getHtml().xpath("//html/body/section/div/div[1]/article/table[1]/tbody/tr").regex(".*"+str+".*");
            String text = html.toString();
            Pattern pattern = Pattern.compile("html(.*?)s");
            Matcher matcher = pattern.matcher(text);


            if(matcher.find()) {
                System.out.println(matcher.group(1));
            }else {
                return; //发送邮件
            }

        }
//        System.out.println("title:" +html);
//        page.putField("name", html);
    }

    @Override
    public Site getSite() {
        return site;
    }
    public static void main(String[] args) {
        Spider.create(new Test()).addUrl("https://www.xttblog.com/?p=1300").addPipeline(new ConsolePipeline())
                .run();
    }
}
