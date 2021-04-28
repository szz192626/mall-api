package com.szz.mall.api.task;

import com.szz.mall.api.entity.MallLoginLog;
import com.szz.mall.api.service.MallLoginLogService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author 囧态汗
 * @date 2021/4/28
 * @description ScheduledTask
 */
@Component
public class ScheduledTask {

    @Resource
    private MallLoginLogService mallLoginLogService;

    //@Scheduled(fixedRate = 3000)
    //每天晚上21：10分执行
    @Scheduled(cron="0 08 22 ? * *")
    public void scheduledTask() {
        MallLoginLog mallLoginLog = MallLoginLog.builder()
                .platform("iOS")
                .userId(1L)
                .apiUri("/api/task")
                .createTime(new Date())
                .build();
        mallLoginLogService.saveLog(mallLoginLog);
        System.out.println("任务执行时间：" + LocalDateTime.now());

    }
}