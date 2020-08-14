package com.sunyong.spider.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test3 {
    public static void main(String[] args) {

        String content = "我要匹配这句话中的“Hello Word”这句短语";
        String regex = "这句话中的“(.*?)”这句";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);

        if(matcher.find()) {
            System.out.println(matcher.group(1));

        }
    }
}
