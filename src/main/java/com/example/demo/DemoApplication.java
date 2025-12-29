package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
System.out.println(new BCryptPasswordEncoder().encode("madhavan2003"));
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches("madhavan2003","$2a$10$84t6DihfzZLffZ63YT..F.96t71zLuTeoqUL2tkssxTsRRw5ibcB2")){
			System.err.print("Password Matched");
		}else{
			System.out.print("Password Not Matched");
		}
}
