package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: qzl
 * @Date: 2020/4/24 10:44
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ConsumerHystrixOrderMain80 {
    public static void main(String[] args) {
            SpringApplication.run(ConsumerHystrixOrderMain80.class,args);
        }
}
