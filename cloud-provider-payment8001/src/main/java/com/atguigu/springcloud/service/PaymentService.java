package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entityes.Payment;

/**
 * @Author: qzl
 * @Date: 2020/3/27 14:35
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentByid(Long id);

}
