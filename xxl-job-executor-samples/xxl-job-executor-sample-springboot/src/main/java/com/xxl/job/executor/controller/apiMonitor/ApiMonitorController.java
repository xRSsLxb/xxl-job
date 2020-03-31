package com.xxl.job.executor.controller.apiMonitor;
/**
 * Created by bxt on 2020/3/24.
 */

import com.alibaba.fastjson.JSON;
import com.xxl.job.executor.service.IApiMonitorService;
import com.xxl.job.executor.util.ExceptionUitl;
import com.xxl.job.executor.util.FunctionUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接口调用监控.
 *
 * @ClassName ApiMonitorController
 * @Author liuxb
 * @Date 2020/3/23
 * @Version 1.0
 */
@RestController
@RequestMapping("/")
public class ApiMonitorController {
    
    /**
     * log4j日志
     */
    private static Logger logger = LoggerFactory.getLogger(ApiMonitorController.class);
    
    @Autowired
    private IApiMonitorService apiMonitorService;
    
    @RequestMapping("apiMonitor")
    public void apiMonitor() {
        logger.info("start ...");
        ApiMonitorJob apiMonitorJob = new ApiMonitorJob();
        try {
            boolean flag = apiMonitorJob.apiMonitor(apiMonitorService);
            logger.info("返回结果: " + flag);
        } catch (Exception e) {
            logger.info(ExceptionUitl.getExceptionMsg(e));
        }
        logger.info("end ...");
    }
    
    /***
     * 用于测试协作方接口是否可以访问,比如403 表示拒绝访问<br>
     * @param apiPath
     * @param requestMethod
     * @return :<br>
     * {
     * apiPath: "http://i.chanjet.com/user/userAndAppInfo",
     * apiPath url encoded: "http%3A%2F%2Fi.chanjet.com%2Fuser%2FuserAndAppInfo",
     * responseCode: 401
     * }
     * @throws IOException
     */
    @RequestMapping(value = "/testApi")
    public String test(String apiPath, String requestMethod) {
        if (FunctionUtils.isBlank(apiPath)) {
            logger.error("apiPath is null");
            return null;
        }
        if (!apiPath.startsWith("http")) {
            //自动在前面补充http://
            apiPath = "http://" + apiPath;
        }
        int responseStatusCode = 0;//-1
        try {
            URL url = new URL(apiPath);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection httpUrlConnection = (HttpURLConnection) urlConnection;
            httpUrlConnection.setDoInput(true);
            httpUrlConnection.setUseCaches(false);
            if (!FunctionUtils.isBlank(requestMethod)) {
                httpUrlConnection.setRequestMethod(requestMethod);
            }
            try {
                httpUrlConnection.connect();
                responseStatusCode = httpUrlConnection.getResponseCode();
            } catch (java.net.UnknownHostException ex) {
                ex.printStackTrace();
            }
            
            httpUrlConnection.disconnect();
            logger.info("responseStatusCode:" + responseStatusCode);
            
            Map<String, Object> map = new HashMap<>();
            map.put("responseCode", responseStatusCode);
            map.put("apiPath", apiPath);
            map.put("apiPath url encoded", URLEncoder.encode(apiPath, "UTF-8"));
            return JSON.toJSONString(map);//序列化
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
