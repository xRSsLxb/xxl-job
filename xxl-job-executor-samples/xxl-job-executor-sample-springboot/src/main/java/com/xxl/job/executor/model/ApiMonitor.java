package com.xxl.job.executor.model;
/**
 * Created by bxt on 2020/3/25.
 */

import java.util.Date;

/**
 * 接口调用监控job实体.
 *
 * @ClassName ApiMonitor
 * @Author liuxb
 * @Date 2020/3/25
 * @Version 1.0
 */
public class ApiMonitor {

    
    private Integer id;
    
    /**
     * 调用api名称
     */
    private String apiName;
    
    /**
     * 调用时间
     */
    private Date invokeTime;
    
    /**
     * 响应码
     */
    private String respCode;
    
    /**
     * 响应体
     */
    private String respMsg;
    
    /**
     * 接口响应耗时
     */
    private Integer invokeCost;
    
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getApiName() {
        return apiName;
    }
    
    public void setApiName(String apiName) {
        this.apiName = apiName;
    }
    
    public Date getInvokeTime() {
        return invokeTime;
    }
    
    public void setInvokeTime(Date invokeTime) {
        this.invokeTime = invokeTime;
    }
    
    public String getRespCode() {
        return respCode;
    }
    
    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }
    
    public Integer getInvokeCost() {
        return invokeCost;
    }
    
    public void setInvokeCost(Integer invokeCost) {
        this.invokeCost = invokeCost;
    }
    
    public String getRespMsg() {
        return respMsg;
    }
    
    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }
    
    
}
