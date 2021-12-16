package com.alibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @SpringBootApplication相当于3个注解 1. @Configuration  定义一个配置类
 * 2. @EnableAutoConfiguration spring boot自动根据jar包的依赖来自动配置项目
 * 3. @ComponentScan  spring自动扫描类上的注解, 并注入spring容器
 */
@SpringBootApplication()
@MapperScan("com.alibaba.mapper")
@EnableOpenApi
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
