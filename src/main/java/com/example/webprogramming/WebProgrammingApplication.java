package com.example.webprogramming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class WebProgrammingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebProgrammingApplication.class, args);
    }

}
