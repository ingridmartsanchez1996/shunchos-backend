package com.shuncosdb.shuncosdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.shuncosdb.shuncosdb.controller")
public class ShuncosdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShuncosdbApplication.class, args);
	}

}
