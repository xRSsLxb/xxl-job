package com.xxl.job.executor.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 通过异常获取异常的堆栈信息
 * @Date 2019/12/18
 * @Param  参数说明
 * @return
*/
public class ExceptionUitl {
    
    public static String getExceptionMsg(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        e.printStackTrace(pw);
        return sw.toString();
    }
}
