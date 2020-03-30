package com.xxl.job.executor.controller.apiMonitor;
/**
 * Created by bxt on 2020/3/24.
 */

import com.xxl.job.executor.service.IApiMonitorService;
import com.xxl.job.executor.util.ExceptionUitl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接口调用监控.
 *
 * @ClassName ApiMonitorController
 * @Author liuxb
 * @Date 2020/3/23
 * @Version 1.0
 */
@RestController
@RequestMapping("/")
public class ApiMonitorController {
    
    /**
     * log4j日志
     */
    private static Logger logger = LoggerFactory.getLogger(ApiMonitorController.class);
    
    @Autowired
    private IApiMonitorService apiMonitorService;
    
    @RequestMapping("apiMonitor")
    public void apiMonitor(){
        logger.info("start ...");
        ApiMonitorJob apiMonitorJob = new ApiMonitorJob();
        try {
            boolean flag = apiMonitorJob.apiMonitor(apiMonitorService);
            logger.info("返回结果: " + flag);
        } catch (Exception e) {
            logger.info(ExceptionUitl.getExceptionMsg(e));
        }
        logger.info("end ...");
    }
}
