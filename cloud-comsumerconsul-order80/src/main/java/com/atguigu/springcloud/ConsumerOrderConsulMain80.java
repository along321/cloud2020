package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: qzl
 * @Date: 2020/4/3 10:34
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerOrderConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderConsulMain80.class,args);
    }
}
