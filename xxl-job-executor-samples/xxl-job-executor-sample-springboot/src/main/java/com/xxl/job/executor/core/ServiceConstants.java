package com.xxl.job.executor.core;
/**
 * Created by bxt on 2020/3/25.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 通用常量定义类.
 *
 * @ClassName ServiceConstants
 * @Author liuxb
 * @Date 2020/3/25
 * @Version 1.0
 */
public class ServiceConstants {
    
    /** 监控类型映射表.*/
    public static final Map<String, String> MONITOR_TYPE_MAP = new HashMap<>();
    /** 监控接口名映射表.*/
    public static final Map<String, String> MONITOR_NAME_MAP = new HashMap<>();
    /** 监控告警级别映射表.*/
    public static final Map<String, String> MONITOR_LEVEL_MAP = new HashMap<>();
    
    
    //监控级别
    
    /** 监控级别 - 无*/
    public static final String REPORT_NULL = "0";
    /** 监控级别 - 低*/
    public static final String REPORT_LOW = "1";
    /** 监控级别 - 中*/
    public static final String REPORT_MEDIUM = "2";
    /** 监控级别 - 高*/
    public static final String REPORT_HIGH = "3";
    /** 监控级别 - 重大*/
    public static final String REPORT_MAJOR = "4";
    
    //监控接口
    public static final String OCR_MONITOR = "ocr";
    public static final String TYC_MONITOR = "tyc";
    public static final String ICP_MONITOR = "icp";
    public static final String IDENTITY_MONITOR = "identity";
    public static final String HUAWEI_MONITOR = "huawei";
    public static final String TENCENT_monitor = "tencent";
    public static final String XIAOMI_MONITOR = "xiaomi";
    public static final String PROAUTH_MONITOR = "proAuth";
    public static final String PROLOGOUT_MONITOR = "proLogout";
    public static final String PROACTIVE_MONITOR = "proActive";
    public static final String CAIXUNMAIL_MONITOR = "caixunMail";
    public static final String SMSGATEWAY_MONITOR = "smsGateway";
    
    //加载监控类型名
    static {
        MONITOR_LEVEL_MAP.put(REPORT_NULL, "正常");
        MONITOR_LEVEL_MAP.put(REPORT_LOW, "低");
        MONITOR_LEVEL_MAP.put(REPORT_MEDIUM, "中");
        MONITOR_LEVEL_MAP.put(REPORT_HIGH, "高");
        MONITOR_LEVEL_MAP.put(REPORT_MAJOR, "重大");
    }
    
    //加载接口名
    static {
        MONITOR_NAME_MAP.put(OCR_MONITOR, "页面访问");
        MONITOR_NAME_MAP.put(TYC_MONITOR, "页面耗时");
        MONITOR_NAME_MAP.put(ICP_MONITOR, "登录接口");
        MONITOR_NAME_MAP.put(IDENTITY_MONITOR, "用户Assertion查询接口");
        MONITOR_NAME_MAP.put(HUAWEI_MONITOR, "会话报活接口");
        MONITOR_NAME_MAP.put(TENCENT_monitor, "会话登出接口");
        MONITOR_NAME_MAP.put(XIAOMI_MONITOR, "短信随机码发送接口");
        MONITOR_NAME_MAP.put(PROAUTH_MONITOR, "各省登录鉴权接口");
        MONITOR_NAME_MAP.put(PROLOGOUT_MONITOR, "各省身份凭证报活接口");
        MONITOR_NAME_MAP.put(PROACTIVE_MONITOR, "各省登出鉴权接口");
        MONITOR_NAME_MAP.put(SMSGATEWAY_MONITOR, "积分短信网关接口");
        MONITOR_NAME_MAP.put(CAIXUNMAIL_MONITOR, "彩讯邮箱网关接口");
    }
}
