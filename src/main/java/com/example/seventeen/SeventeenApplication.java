package com.example.seventeen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
@RestController
public class SeventeenApplication {

	@GetMapping("/welcome")
	public String welcome(){
		return "Spring Boot Docker Demo";
	}
	@GetMapping("/helloDev")
	public String helloDev(){
		return "This is dev branch";
	}
	public static void main(String[] args) {
		SpringApplication.run(SeventeenApplication.class, args);
	}

}
