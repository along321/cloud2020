package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: qzl
 * @Date: 2020/4/29 16:59
 */
@SpringBootApplication
@EnableEurekaClient
public class GatwayMain9527 {
    public static void main(String[] args) {
            SpringApplication.run(GatwayMain9527.class,args);
        }
}
