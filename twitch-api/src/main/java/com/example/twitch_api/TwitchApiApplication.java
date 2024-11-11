package com.example.twitch_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.twitch_api")
@ComponentScan(basePackages = "com.example.twitch_api")
@EnableJpaRepositories(basePackages = "com.example.twitch_api")  // Scan for repositories across the entire package
@EntityScan(basePackages = "com.example.twitch_api")  // Scan for entities across the entire package
public class TwitchApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwitchApiApplication.class, args);
    }

}
