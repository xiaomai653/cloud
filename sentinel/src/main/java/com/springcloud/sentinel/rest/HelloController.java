package com.springcloud.sentinel.rest;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaomai
 * @date 2022/5/30
 */
@RestController
public class HelloController {

    @SentinelResource("resource")
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
