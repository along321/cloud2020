package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: qzl
 * @Date: 2020/4/24 10:19
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_ok(@PathVariable("id") Integer id){
        String result = paymentService.PaymentInfo_ok(id);
        log.info("**************************result:"+result);
        return result;
    }
    @GetMapping("/payment/hystrix/timeOut/{id}")
    public String PaymentInfo_timeOut(@PathVariable("id") Integer id){
        String result = paymentService.PaymentInfo_timeOut(id);
        log.info("**************************result:"+result);
        return result;
    }

    @GetMapping("/payment/circuit/{id}")
    public String PaymentInfo_circuit(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("**************************result:"+result);
        return result;
    }
}
