package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: qzl
 * @Date: 2020/4/3 11:11
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myrule(){
        return new RandomRule();
    }
}
