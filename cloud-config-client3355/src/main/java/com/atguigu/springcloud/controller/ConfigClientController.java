package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qzl
 * @Date: 2020/5/6 16:31
 */
@RestController
@RefreshScope//检测改变进行刷新
public class ConfigClientController {
    @Value("${config.info}")
    private String configinfo;

    @GetMapping("/configInfo")
    public String getConfiginfo(){
        return configinfo;
    }
}
