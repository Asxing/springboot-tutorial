package com.holddie.springboot.elasticsearch.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations={"classpath:spring-search.xml"})
public class ElasticsearchTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchTutorialApplication.class, args);
	}
}
