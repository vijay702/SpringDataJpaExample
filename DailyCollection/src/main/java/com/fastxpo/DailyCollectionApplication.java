package com.fastxpo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan({"com.fastxpo.model","com.fastxpo.controller","com.fastxpo.repository","com.fastxpo.service"})
@EnableAutoConfiguration

public class DailyCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyCollectionApplication.class, args);
	}

}
