package com.example.springmybatisplusdemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringMyBatisPlusDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMyBatisPlusDemoApplication.class, args);
    }

}
