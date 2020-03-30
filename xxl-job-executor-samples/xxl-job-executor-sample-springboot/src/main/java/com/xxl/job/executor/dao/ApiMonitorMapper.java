package com.xxl.job.executor.dao;

import com.xxl.job.executor.model.ApiMonitor;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 详细介绍类情况.
 *
 * @ClassName ApiMonitorMapper
 * @Author liuxb
 * @Date
 * @Version 1.0
 */
@Mapper
@Repository
public interface ApiMonitorMapper {
    
    /**
     * api单位时间内成功率.
     * @Date 2020/3/25
     * @Param [startTime, endTime]
     * @return java.util.List<com.xxl.job.executor.model.ApiMonitor>
    */
    List<ApiMonitor> selectApiMonitorReport(@Param("startTime") String startTime, @Param("endTime") String endTime);
}
