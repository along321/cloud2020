package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entityes.CommonResult;
import com.atguigu.springcloud.entityes.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: qzl
 * @Date: 2020/3/27 14:38
 */
@Slf4j
@RestController
@RequestMapping(value = "payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverprot;

    @PostMapping(value = "/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("****插入结果*****");
        if(result > 0){
            return new CommonResult(200,"添加成功,serverProt:"+serverprot);
        }else{
            return new CommonResult(400,"添加失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentByid(id);
        log.info("***查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询数据成功,serverport:"+serverprot , payment);
        } else {
            return new CommonResult(444, "没有对应记录", null);
        }
    }

    @GetMapping(value = "/lb")
    public String getlb(){
        return serverprot;
    }

}
