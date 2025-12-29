package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String rawPassword = "madhavan2003";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println(encodedPassword);

        if (encoder.matches(rawPassword, encodedPassword)) {
            System.out.println("Password Matched");
        } else {
            System.out.println("Password Not Matched");
        }
    }
}
