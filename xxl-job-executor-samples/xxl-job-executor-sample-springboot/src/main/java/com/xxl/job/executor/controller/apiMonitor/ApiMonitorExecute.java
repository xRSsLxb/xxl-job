package com.xxl.job.executor.controller.apiMonitor;
/**
 * Created by bxt on 2020/3/25.
 */

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.service.IApiMonitorService;
import com.xxl.job.executor.util.ExceptionUitl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ApiMonitor调度处理器.
 *
 * @ClassName ApiMonitorJob
 * @Author liuxb
 * @Date 2020/3/25
 * @Version 1.0
 */
@Component
public class ApiMonitorExecute {
    
    /**.
     * log4j日志
     */
    private static Logger log = LoggerFactory.getLogger(ApiMonitorExecute.class);
    
    @Autowired
    private IApiMonitorService apiMonitorService;
    
    @XxlJob("apiMonitorJobHandler")
    public ReturnT<String> execute(String param)  {
        ApiMonitorJob apiMonitorJob = new ApiMonitorJob();
        try {
            boolean flag = apiMonitorJob.apiMonitor(apiMonitorService);
            XxlJobLogger.log("返回结果: " + flag);
            log.info("返回结果: " + flag);
        } catch (Exception e) {
            XxlJobLogger.log(ExceptionUitl.getExceptionMsg(e));
            log.info(ExceptionUitl.getExceptionMsg(e));
        }
        return ReturnT.SUCCESS;
    }
}
