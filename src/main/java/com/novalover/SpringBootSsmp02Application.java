package com.novalover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootSsmp02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSsmp02Application.class, args);
    }

}
