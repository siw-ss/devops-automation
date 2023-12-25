package com.example.seventeen;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SeventeenApplicationTests {

	@Test
	void contextLoads() {
		SeventeenApplication app = new SeventeenApplication();
		assertEquals("Spring Boot Docker Demo",app.welcome());
	}

}
