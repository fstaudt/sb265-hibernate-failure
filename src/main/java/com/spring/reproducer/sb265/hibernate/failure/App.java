package com.spring.reproducer.sb265.hibernate.failure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.spring.reproducer", proxyBeanMethods = false)
class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
