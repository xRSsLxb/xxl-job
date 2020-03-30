package com.xxl.job.executor.service.impl;
/**
 * Created by bxt on 2020/3/25.
 */

import com.xxl.job.executor.core.ds.DS;
import com.xxl.job.executor.dao.ApiMonitorMapper;
import com.xxl.job.executor.model.ApiMonitor;
import com.xxl.job.executor.service.IApiMonitorService;
import com.xxl.job.executor.util.DateUtils;
import com.xxl.job.executor.util.FunctionUtils;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 详细介绍类情况.
 *
 * @ClassName ApiMonitorServiceImpl
 * @Author liuxb
 * @Date 2020/3/25
 * @Version 1.0
 */
@Service("apiMonitorService")
public class ApiMonitorServiceImpl implements IApiMonitorService{
    /**.
     * log4j日志
     */
    private static Logger logger = LoggerFactory.getLogger(ApiMonitorServiceImpl.class);
    
    @Autowired
    private ApiMonitorMapper apiMonitorMapper;
    
    /**
     * 接口调用监控
     */
    @Override
    @DS("testdb")
    public boolean selectApiMonitorReport() throws Exception{
        boolean flag = true;
        String startTime = DateUtils.getStartTime();
        String endTime = DateUtils.getEndTime();
        List<ApiMonitor> list = apiMonitorMapper.selectApiMonitorReport(startTime, endTime);
        if(FunctionUtils.isListNotEmpty(list)){
            for (int i = 0; i < list.size(); i++) {
                ApiMonitor apiMonitor = list.get(i);
                if(apiMonitor.getInvokeCost() > 400){
                    flag = false;
                }
            }
        }
        
        return flag;
    }
}
