package com.sunyong.spider.entry;

import lombok.Data;

@Data
public class TaskInfo {

    private String task_name;
    private String task_url;
    private String delay_time;
    private String last_batch_time;
    private String getting_time;
    private String input_size;
    private String scheduling_delay;
    private String processing_time;
    private String total_delay;


}
