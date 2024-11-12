package com.example.twitch_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.twitch_api.Users")
@EnableJpaRepositories(basePackages = "com.example.twitch_api.Users")
@EntityScan(basePackages = "com.example.twitch_api.Users")
public class TwitchApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(TwitchApiApplication.class, args);
    }
}
