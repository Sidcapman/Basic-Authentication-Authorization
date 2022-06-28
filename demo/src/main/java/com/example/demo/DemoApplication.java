package com.example.demo;

import com.example.demo.UserService.UserService;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService)
	{
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));

			userService.saveUser(new User(null, "Anugam","sidcapman","123456",new ArrayList<>()));
			userService.saveUser(new User(null, "LaxmiNarayana","lucky","123456",new ArrayList<>()));

			userService.addRoletoUser("lucky","ROLE_ADMIN");
			userService.addRoletoUser("sidcapman","ROlE_USER");
//			userService.addRoletoUser("sidcapman","ROLE_ADMIN");

		};
	}
}
