package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author: qzl
 * @Date: 2020/4/24 10:14
 */
@Service
public class PaymentService {

    public String PaymentInfo_ok(Integer id){
        return "线程池："+ Thread.currentThread().getName()+" PaymentInfo_OK,id"+id+"\t"+"^_^哈哈";
    }

    @HystrixCommand(fallbackMethod = "PaymentInfo_TimeOutHandler",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String PaymentInfo_timeOut(Integer id){
        int timeOut = 5;
        try {
            TimeUnit.SECONDS.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int age = 10/0;
        return "线程池："+ Thread.currentThread().getName()+" PaymentInfo_timeOut,id"+id+"\t"+"^_^哈哈 耗时（秒）:";
    }

    public String PaymentInfo_TimeOutHandler(Integer id){
        return "线程池："+ Thread.currentThread().getName()+" 系统繁忙，请稍后再试,id"+id+"\t"+"o(╥﹏╥)o";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开始断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后进行跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("****id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();//糊涂工具包  生成UUID
        return Thread.currentThread().getName()+"调用成功，流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id")Integer id){
        return "id 不能为负数，请稍后再试！！";
    }

}
