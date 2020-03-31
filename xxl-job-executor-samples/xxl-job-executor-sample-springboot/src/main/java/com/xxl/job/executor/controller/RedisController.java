/*
 * File_Name RedisController.java 2018年5月29日
 * version 
 * copyright (c)2018 Asiainfo Network Security Group Security Innovative Operation Dept. All rights reserved.
 */
package com.xxl.job.executor.controller;

import com.xxl.job.executor.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**.
 * Redis测试.
 * @author liuxb
 */
@RestController
@RequestMapping("/")
public class RedisController {
    
    @Autowired
    private RedisService redisService;

    @RequestMapping("text")
    public String demoTest() {
        System.out.println("缓存测试");
        redisService.set("1", "value22222");
        System.out.println("缓存获取测试");
        String info = (String) redisService.get("1");
        return info;
    }
}
