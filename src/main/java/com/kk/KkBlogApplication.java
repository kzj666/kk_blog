package com.kk;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.kk.entity")
@SpringBootApplication
public class KkBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(KkBlogApplication.class, args);
    }

}
