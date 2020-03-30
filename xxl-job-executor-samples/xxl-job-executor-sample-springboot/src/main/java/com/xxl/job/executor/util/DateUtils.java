package com.xxl.job.executor.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 详细介绍类情况.
 *
 * @ClassName DateUtils
 * @Author liuxb
 * @Date 2020/3/25
 * @Version 1.0
 */
public class DateUtils {
    
    /**.
     * log4j日志
     */
    private static Logger log = LoggerFactory.getLogger(DateUtils.class);
    
    /**
     * api监控开始时间.
    */
    public static String getStartTime() {
        LocalDateTime minusMinutes = LocalDateTime.now().minusMinutes(10);
        return minusMinutes.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    
    /**
     * api监控结束时间.
     */
    public static String getEndTime() {
        LocalDateTime minutes = LocalDateTime.now().minusMinutes(5);
        return minutes.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
