package com.sunny.poa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sunny.poa.dao")
public class PoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoaApplication.class, args);
	}

}
