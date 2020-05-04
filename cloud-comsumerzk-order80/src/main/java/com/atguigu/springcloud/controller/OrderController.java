package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author: qzl
 * @Date: 2020/3/30 15:08
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

//    private static final String INCOKE_URL = "http://localhost:8001";
    private static final String INCOKE_URL = "http://CLOUD-PAYMENT-SERVICE"; //使用服务提供方向eureka注册的服务名称

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/get/{id}")
    public String get(@PathVariable("id")int id){
        String result = restTemplate.getForObject(INCOKE_URL+"/payment/get/"+id,String.class);
        return result;
    }
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null && instances.size() < 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instance(instances);

        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

    public static void main(String[] args) {
        int[] arr = new int[10];//声明并同时创建一个10个整数组成的数组

        for (int i = 0; i < arr.length; i++) {//生成一个10个随机数组成的数组

            arr[i] = (int) (Math.random() * 100);

            System.out.print(arr[i]+"\t");//输出查看数组
        }

        arr = sort(arr);

        System.out.println("");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");//查看排序后的数组
        }
        System.out.println("");

        //测试
        int k = findKth(arr,3);
        System.out.println("k="+k);
    }

    /**
     * 查找数组arr中第k小的奇数,如果不存在则返回0. (arr[i] > 0 (i>=0))
     * 计算出时间复杂度（注意代码注释，尽可能不用全排序，不要使⽤库函数或脚本中已经实现好的排序算法和⼯具, 需要⾃⼰实现数据结构和所需要的算法）
     * 格式:
     * @param arr
     * @param k
     * @return 第k小的奇数
     */
    private static int findKth(int[] arr, int k){
        arr = sort(arr);//进行冒泡排序
        int num = 1;//时间复杂度
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2!=0){
                if(num==k){
                    return arr[i];
                }
                num++;//继续查找
            }

        }
        return 0;//找不到返回0;
    }


    private static int[] sort(int[] arr){

        for(int i=0;i<arr.length-1;i++) {//for循环嵌套使用，i代表的是每一轮冒泡比较的轮数

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {//j代表的是数组里具体的前后两个数相比较

                    int num = arr[j];

                    arr[j] = arr[j + 1];

                    arr[j + 1] = num;//引入“第三者”num这个数，首尾相连，完成对前后两个数的“移形换位”
                }
            }
        }

        return arr;
    }
}