package com.nucleiassignment3.HttpServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class HttpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpServerApplication.class, args);
	}

}
