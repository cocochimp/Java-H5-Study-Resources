package com.koko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//启动类
@SpringBootApplication
@EnableEurekaClient //在服务启动后自动注册到Eureka中
@EnableDiscoveryClient
public class DeptProvider_8081 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8081.class,args);
    }
}
