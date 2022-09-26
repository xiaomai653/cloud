package com.springcloud.sso.client2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xiaomai
 * @date 2022/5/28
 */
@EnableOAuth2Sso
@EnableDiscoveryClient
@SpringBootApplication
public class SsoClientTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoClientTwoApplication.class);
    }

}
