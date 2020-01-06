package com.lidong1.license.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimeRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Scheduled(cron = "0 30 9 1 7 ?")
    public void expore() {

        logger.info("定时任务开始！");
        LoginInterceptor.expore = true;
    }
}
