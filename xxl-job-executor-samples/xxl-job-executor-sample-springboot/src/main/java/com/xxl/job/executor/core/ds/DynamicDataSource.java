package com.xxl.job.executor.core.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 当前数据源.
 * @Date 2020/3/24
 * @author liuxb
*/
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**.
     * log4j日志
     */
    private static Logger log = LoggerFactory.getLogger(AbstractRoutingDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        log.info("当前数据源为" + DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();
    }
}
