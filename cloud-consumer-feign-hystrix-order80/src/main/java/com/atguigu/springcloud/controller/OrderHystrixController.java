package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.ConsumerHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: qzl
 * @Date: 2020/4/24 10:48
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "PaymentInfo_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private ConsumerHystrixService consumerHystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_ok(@PathVariable("id") Integer id){
        return consumerHystrixService.PaymentInfo_ok(id);
    }

    @GetMapping("/payment/hystrix/timeOut/{id}")
//    @HystrixCommand(fallbackMethod = "PaymentInfo_TimeOutHandler",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")})
    @HystrixCommand
    public String PaymentInfo_timeOut(@PathVariable("id") Integer id){
        int age = 10/0;
        return consumerHystrixService.PaymentInfo_timeOut(id);
    }

    public String PaymentInfo_TimeOutHandler(Integer id){
        return "调用支付系统失败，请检查错误";
    }
    public String PaymentInfo_Global_FallbackMethod(){
        return "Global异常处理信息";
    }

}
