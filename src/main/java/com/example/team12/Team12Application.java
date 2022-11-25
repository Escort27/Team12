package com.example.team12;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.example.team12.dao")
@SpringBootApplication
@EnableScheduling
public class Team12Application {

	public static void main(String[] args) {
		SpringApplication.run(Team12Application.class, args);
	}
}
