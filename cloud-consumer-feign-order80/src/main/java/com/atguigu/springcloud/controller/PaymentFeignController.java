package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entityes.CommonResult;
import com.atguigu.springcloud.entityes.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qzl
 * @Date: 2020/4/4 10:16
 */
@RestController
@Slf4j
public class PaymentFeignController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/consumet/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }

    @GetMapping(value = "/payment/timeout")
    public String paymentFeignTimeout(){
        return paymentService.paymentFeignTimeout();
    }
}
