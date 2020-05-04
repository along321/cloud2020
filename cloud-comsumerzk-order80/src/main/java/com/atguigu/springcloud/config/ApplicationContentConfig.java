package com.atguigu.springcloud.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: qzl
 * @Date: 2020/3/30 15:05
 */
@Configuration
public class ApplicationContentConfig {

    @Bean
//    @LoadBalanced//赋予RestTemplate负载均衡能力   Ribbon 负载均衡能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
