package com.xxl.job.executor.core.ds;

import com.xxl.job.executor.util.ExceptionUitl;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 自定义注解 + AOP的方式实现数据源动态切换.
 *
 * @author liuxb
 * @Date 2020/3/24
 */
@Aspect
@Component
public class DynamicDataSourceAspect {
    
    /**
     * .
     * log4j日志
     */
    private static Logger log = LoggerFactory.getLogger(DynamicDataSourceAspect.class);
    
    @Before("@annotation(DS)")
    public void beforeSwitchDS(JoinPoint point) {
        //获得当前访问的class  
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法名  
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型  
        Class[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
        String dataSource = DataSourceContextHolder.DEFAULT_DS;
        try {
            // 得到访问的方法对象  
            Method method = className.getMethod(methodName, argClass);
            // 判断是否存在@DS注解  
            if (method.isAnnotationPresent(DS.class)) {
                DS annotation = method.getAnnotation(DS.class);
                // 取出注解中的数据源名  
                dataSource = annotation.value();
            }
            //log.info("dataSource:" + dataSource);
        } catch (Exception e) {
            log.info(ExceptionUitl.getExceptionMsg(e));
        }
        // 切换数据源  
        DataSourceContextHolder.setDB(dataSource);
    }
    
    @After("@annotation(DS)")
    public void afterSwitchDS(JoinPoint point) {
        DataSourceContextHolder.clearDB();
    }
}
