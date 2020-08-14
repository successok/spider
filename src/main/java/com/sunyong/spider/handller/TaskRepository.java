package com.sunyong.spider.handller;

import lombok.Data;

import java.util.Map;
@Data
public class TaskRepository {
    public static Map resultMap;


    public void add(String taskname,Object object) {
        resultMap.put(taskname, object);


    }
}
