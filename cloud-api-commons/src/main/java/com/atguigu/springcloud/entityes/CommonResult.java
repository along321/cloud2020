package com.atguigu.springcloud.entityes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: qzl
 * @Date: 2020/3/27 14:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    private int code;

    private String msg;

    private T data;

    public CommonResult(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

}
