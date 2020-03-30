package com.xxl.job.executor.core.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 多数据源.
 * @Date 2020/3/24
 * @author liuxb
*/
public class DataSourceContextHolder {
    /**
     * 默认数据源
     */
    public static final String DEFAULT_DS = "localhostdb";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**.
     * log4j日志
     */
    private static Logger log = LoggerFactory.getLogger(DataSourceContextHolder.class);

    // 设置数据源名
    public static void setDB(String dbType) {
        log.info("切换到{" + dbType + "}数据源");
        contextHolder.set(dbType);
    }

    // 获取数据源名
    public static String getDB() {
        //log.info("获取ThreadLocal数据源名: " + contextHolder.get());
        return contextHolder.get();
    }

    // 清除数据源名
    public static void clearDB() {
        contextHolder.remove();
    }
}
