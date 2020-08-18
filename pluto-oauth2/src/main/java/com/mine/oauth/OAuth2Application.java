package com.mine.oauth;

import com.mine.common.feign.annotation.EnableMyFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableMyFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class OAuth2Application {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2Application.class, args);
    }

}