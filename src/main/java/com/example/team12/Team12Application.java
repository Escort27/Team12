package com.example.team12;

import com.example.team12.service.Impl.photoServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.team12.dao")
@SpringBootApplication
public class Team12Application {

	public static void main(String[] args) {
		SpringApplication.run(Team12Application.class, args);

	}

}
