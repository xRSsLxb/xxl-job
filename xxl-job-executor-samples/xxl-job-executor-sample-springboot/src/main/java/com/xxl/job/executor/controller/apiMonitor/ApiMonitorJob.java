package com.xxl.job.executor.controller.apiMonitor;
/**
 * Created by bxt on 2020/3/24.
 */

import com.xxl.job.executor.service.IApiMonitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 接口调用监控.
 *
 * @ClassName ApiMonitorJob
 * @Author liuxb
 * @Date 2020/3/24
 * @Version 1.0
 */
class ApiMonitorJob {
    
    /**
     * log4j日志
     */
    private static Logger log = LoggerFactory.getLogger(ApiMonitorJob.class);
    
    boolean apiMonitor(IApiMonitorService apiMonitorService) throws Exception {
        boolean flag = apiMonitorService.selectApiMonitorReport();
        return flag;
        
    }
    
}
