package com.practice.letsCheckQuiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LetsCheckQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(LetsCheckQuizApplication.class, args);
	}

}
