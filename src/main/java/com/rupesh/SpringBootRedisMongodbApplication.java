package com.rupesh;

import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(info = @Info(title = "Book API", version = "2.0", description = "Book Information"))
public class SpringBootRedisMongodbApplication {
	public static Logger LOGGER = LoggerFactory.getLogger(SpringBootRedisMongodbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisMongodbApplication.class, args);
		LOGGER.info("*********SpringBootRedisMongodbApplication started successfully*********");
	}
}
