package com.holddie.springboot.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.holddie.springboot")
@SpringBootApplication
@MapperScan("com.holddie.springboot.mybatis.*.dao*")
public class MybatisGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisGeneratorApplication.class, args);
	}
}
