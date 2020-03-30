package com.xxl.job.executor.controller;
/**
 * Created by bxt on 2020/3/24.
 */


import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

/**
 * XxlJob开发示例（Bean模式）.
 *
 * @ClassName JobHandlerDemo
 * @Author liuxb
 * @Date 2020/3/24
 * @Version 1.0
 */

@Component
public class JobHandlerDemo {
    
    
    @XxlJob("demoJobHandlerExecute")
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("调用成功...");
        System.out.println("Hello World...");
        return ReturnT.SUCCESS;
    }
}
