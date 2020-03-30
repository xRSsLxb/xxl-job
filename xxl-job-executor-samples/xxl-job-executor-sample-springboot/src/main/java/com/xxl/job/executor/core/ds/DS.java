package com.xxl.job.executor.core.ds;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解.
 * @Date 2020/3/24
 * @author liuxb
*/
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface DS {

    String value() default "localhostdb";
}
