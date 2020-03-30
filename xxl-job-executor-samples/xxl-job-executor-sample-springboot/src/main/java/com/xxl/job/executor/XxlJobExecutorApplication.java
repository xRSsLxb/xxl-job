package com.xxl.job.executor;

import com.xxl.job.executor.core.ds.DataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * @author liuxb
 * 动态数据源配置类DataSourceConfig导致spring 循环引用错误
 * 在Spring boot启动的时候排除Spring的，并引入自己的动态数据源类
 */
@Import({DataSourceConfig.class})
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class XxlJobExecutorApplication {

	public static void main(String[] args) {
        SpringApplication.run(XxlJobExecutorApplication.class, args);
	}

}