package com.springcloud.consumer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: xiaomai
 * @date: 2022/5/19
 */
@RestController
public class ConsumeController {

    @Value("${spring.application.name}")
    private String name;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/echo/app-name")
    public String echoAppName() {
        //使用 LoadBalanceClient 和 RestTemolate 结合的方式来访问
        List<ServiceInstance> instances = discoveryClient.getInstances("provider");
        // 选择第一个
        ServiceInstance instance = instances.size() > 0 ? instances.get(0) : null;
        String url = String.format("http://%s:%s/echo/%s", instance.getHost(), instance.getPort(), name);
        System.out.println("request url:" + url);
        return restTemplate.getForObject(url, String.class);
    }

}

