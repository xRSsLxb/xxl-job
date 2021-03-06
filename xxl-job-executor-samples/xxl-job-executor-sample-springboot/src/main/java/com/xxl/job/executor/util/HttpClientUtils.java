package com.xxl.job.executor.util;
/**
 * Created by bxt on 2020/3/31.
 */

import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.HeadMethod;
import org.apache.commons.httpclient.methods.OptionsMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.TraceMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.params.CoreConnectionPNames;

/**
 * 模拟各种Http请求工具类.
 *
 * @ClassName HttpClientUtils
 * @Author liuxb
 * @Date 2020/3/31
 * @Version 1.0
 */
public class HttpClientUtils {
    
    /*public static Map<String, Object> request(HttpRequestBo bo) {
        
        Map<String, Object> map = new HashMap<String, Object>();
        double begin = System.currentTimeMillis();
        String type = bo.getType();
        String url = bo.getUrl();
        HttpMethodBase method = null;
        try {
            //匹配请求
            if ("Post".equals(type)) {
                method = new PostMethod(url);
            } else if ("Get".equals(type)) {
                method = new GetMethod(url);
            } else if ("Delete".equals(type)) {
                method = new DeleteMethod(url);
            } else if ("Put".equals(type)) {
                method = new PutMethod(url);
            } else if ("Trace".equals(type)) {
                method = new TraceMethod(url);
            } else if ("Head".equals(type)) {
                method = new HeadMethod(url);
            } else if ("Options".equals(type)) {
                method = new OptionsMethod(url);
            }
            
            HttpClient client = new HttpClient();
            //请求超时
            client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 556000);
            //读取超时
            client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 555000);
            client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
            client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
            
            method.setRequestHeader("Connection", "close");
            method.setRequestHeader("Referer",
                    "https://www.sojson.com");
            method.setRequestHeader("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:42.0) Gecko/20100101 Firefox/42.0");
            
            //设置参数
            String[] keys = bo.getKeys(), values = bo.getValues();
            if (StringUtils.isNotBlank(keys, values)) {
                NameValuePair[] params = new NameValuePair[keys.length];
                for (int i = 0; i < keys.length; i++) {
                    params[i] = new NameValuePair(keys[i], values[i]);
                }
                method.setQueryString(params);
            }
            //设置请求头 和上面方法一致，如果一样，那么就覆盖。
            String[] headKeys = bo.getHeadKeys(), headValues = bo.getHeadValues();
            for (int i = 0; StringUtils.isNotBlank(headKeys, headValues) && i < headKeys.length; i++) {
                method.setRequestHeader(headKeys[i], headValues[i]);
            }
            
            int status = client.executeMethod(method);
            map.put("status", status);
            
            Header[] heads = method.getResponseHeaders();
            //获取请求的Host，用于IP解析
            String host = method.getHostConfiguration().getHost();
            
            StringBuffer sb = new StringBuffer(20);
            for (Header header : heads) {
                sb.append(header.getName())
                        .append(" : ")
                        .append(header.getValue())
                        .append("\r\n");
            }
            //头信息
            map.put("head", sb.toString());
            String result = method.getResponseBodyAsString();
            map.put("result", result);
            String ip;
            try {
                InetAddress iAddress = InetAddress.getByName(host);
                ip = iAddress.getHostAddress();
                map.put("host", ip);
            } catch (Exception e) {
                LoggerUtils.fmtError(HttpClientUtils.class, e, "获取IP地址失败，域名:[%s]", host);
            }
        } catch (UnknownHostException e) {
            //域名错误
            map.put("message", "请输入正确的网址");
            LoggerUtils.fmtError(HttpClientUtils.class, e, "网址异常[%s]", url);
        } catch (SocketTimeoutException e) {
            //超时
            map.put("message", "请求地址超时");
            LoggerUtils.fmtError(HttpClientUtils.class, e, "请求地址超时[%s]", url);
        } catch (Exception e) {
            //其他异常
            map.put("message", "请求出现未知异常，请重试！");
            LoggerUtils.fmtError(HttpClientUtils.class, e, "请求出现未知异常，请重试！[%s]", url);
        }
        double end = System.currentTimeMillis();
        map.put("time", (end - begin) / 1000);
        return map;
        
    }*/
}
