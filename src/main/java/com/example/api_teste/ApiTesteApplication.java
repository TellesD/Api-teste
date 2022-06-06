package com.example.api_teste;

import com.example.api_teste.repository.CoinRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.api_teste.model")
@EnableMongoRepositories(basePackageClasses = CoinRepository.class)
public class ApiTesteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTesteApplication.class, args);
    }

}
