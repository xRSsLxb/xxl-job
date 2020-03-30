package com.xxl.job.executor.util;
/**
 * Created by bxt on 2020/3/25.
 */

import java.util.List;

/**
 * 详细介绍类情况.
 *
 * @ClassName FunctionUtils
 * @Author liuxb
 * @Date 2020/3/25
 * @Version 1.0
 */
public class FunctionUtils {
    
    /**
     * 判断list不为为空
     *
     * @param list
     * @return boolean
     * @Date 2020/3/25
     */
    public static <T> boolean isListNotEmpty(List<T> list) {
        return list != null && !list.isEmpty();
    }
    
    /**
     * 判断list为空
     *
     * @param list
     * @return boolean
     * @Date 2020/3/25
     */
    public static <T> boolean isListEmpty(List<T> list) {
        return !isListNotEmpty(list);
    }
    
    /**
     * 判断list为空
     *
     * @param s,defaultValue
     * @return boolean
     * @Date 2020/3/25
     */
    public static int parseInt(String s, int defaultValue) throws Exception {
        if (s == null || "".equals(s)) {
            return defaultValue;
        }
        return Integer.parseInt(s);
    }
    
    /**
     * 字符串是否为空
     * @Date 2020/3/9
     * @Param [str] 参数说明
     * @return boolean
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                //判断字符是否为空格、制表符、tab.
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }
    
}
