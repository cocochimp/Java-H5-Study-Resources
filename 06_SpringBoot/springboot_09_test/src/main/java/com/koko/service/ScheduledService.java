package com.koko.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    //秒   分   时     日   月   周几
    //0 * * * * MON-FRI
    //注意cron表达式的用法；
    @Scheduled(cron = "0 * * * * 0-7")
    public void hello(){
        System.out.println("hello.....");
    }

}
