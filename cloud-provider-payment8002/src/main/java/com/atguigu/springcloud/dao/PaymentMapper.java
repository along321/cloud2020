package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entityes.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: qzl
 * @Date: 2020/3/27 14:25
 */
@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    Payment getPaymentByid(@Param("id")Long id);
}
