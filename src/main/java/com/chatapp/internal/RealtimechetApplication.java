package com.chatapp.internal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "main.java.com.chatapp")
public class RealtimechetApplication {

    public static void main(String[] args) {
        SpringApplication.run(RealtimechetApplication.class, args);
    }
}
