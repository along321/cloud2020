package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: qzl
 * @Date: 2020/4/24 10:45
 */
@Component
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE")
public interface ConsumerHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeOut/{id}")
    public String PaymentInfo_timeOut(@PathVariable("id") Integer id);
}
