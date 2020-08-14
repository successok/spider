package com.sunyong.spider.contoller;

import com.sunyong.spider.handller.TaskRepository;
import com.sunyong.spider.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/getData")
    public Map getData() {

        //每隔6秒ajax发送一次请求



        return TaskRepository.resultMap;
    }




}
