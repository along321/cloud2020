package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: qzl
 * @Date: 2020/4/2 11:55
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekeServerMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekeServerMain7002.class,args);
    }
}
