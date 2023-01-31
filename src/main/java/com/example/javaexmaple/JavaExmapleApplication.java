package com.example.javaexmaple;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.javaexmaple.model.User;
import com.example.javaexmaple.service.UserService;
import com.github.javafaker.Faker;

@SpringBootApplication
public class JavaExmapleApplication {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(JavaExmapleApplication.class, args);
	}
	@Bean
	CommandLineRunner clCommandLineRunner(){
		return args ->{
			int max = 1000;
            Faker faker = new Faker(new Locale("en-US"));
			for (int i = 0; i < max; i++) {
				User user = new User(i, faker.name().firstName(), faker.name().lastName(), faker.beer().hashCode());
				userService.createUser(user);
			}
		};
	}
}
