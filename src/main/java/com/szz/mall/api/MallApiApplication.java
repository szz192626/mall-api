package com.szz.mall.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = {"com.szz.mall.api.mapper"})
@EnableScheduling
public class MallApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallApiApplication.class, args);
    }

}
