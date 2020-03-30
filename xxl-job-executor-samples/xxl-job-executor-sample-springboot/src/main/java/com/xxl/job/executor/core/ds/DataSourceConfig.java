package com.xxl.job.executor.core.ds;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**.
 * 多数据源配置类.
 * @author liuxb
 * @see
 */
@Configuration
public class DataSourceConfig {

    /**.
     * log4j日志
     */
    private static Logger log = LoggerFactory.getLogger(DataSourceConfig.class);

    @Bean(name = "localhostdb")
    @Qualifier("localhostdb")
    @ConfigurationProperties(prefix = "spring.datasource.localhostdb")
    public DataSource localHostDB() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "testdb")
    @Qualifier("testdb")
    @ConfigurationProperties(prefix = "spring.datasource.testdb")
    public DataSource testDB() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     * @return
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(localHostDB());

        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.put("localhostdb", localHostDB());
        dsMap.put("testdb", testDB());

        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

    /**
     * 配置@Transactional注解事物
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }

}