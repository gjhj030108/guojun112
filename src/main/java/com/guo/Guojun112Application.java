package com.guo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Guojun112Application {

    public static void main(String[] args) {
        SpringApplication.run(Guojun112Application.class, args);
    }

}
