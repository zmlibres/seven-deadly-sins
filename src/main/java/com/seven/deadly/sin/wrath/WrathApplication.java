package com.seven.deadly.sin.wrath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class WrathApplication {

	public static void main(String[] args) {
		SpringApplication.run(WrathApplication.class, args);
	}

}
