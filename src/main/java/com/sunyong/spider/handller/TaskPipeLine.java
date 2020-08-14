package com.sunyong.spider.handller;

import com.sunyong.spider.entry.TaskInfo;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

public class TaskPipeLine implements Pipeline {



    @Autowired
    protected TaskRepository taskRepository;

    @Override
    public void process(ResultItems resultItems, Task task) {
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {

        }
        TaskInfo taskInfo=(TaskInfo) resultItems.get("task");

        taskRepository.add(taskInfo.getTask_name(),taskInfo);
    }
}
