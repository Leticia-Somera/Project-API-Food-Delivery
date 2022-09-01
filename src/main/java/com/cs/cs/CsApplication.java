package com.cs.cs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CsApplication {

	public static void main(String[] args) {
		System.out.print("testing cs app");
		SpringApplication.run(CsApplication.class, args);
	}

}
