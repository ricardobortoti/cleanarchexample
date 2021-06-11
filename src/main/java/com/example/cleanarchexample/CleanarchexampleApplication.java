package com.example.cleanarchexample;

import com.example.cleanarchexample.adapters.persistence.repository.BankAccountRepository;
import com.example.cleanarchexample.application.domain.BankAccount;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class CleanarchexampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CleanarchexampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner bootstrapData(BankAccountRepository repository) {
        return (args) -> {
            BigDecimal initialBalance = BigDecimal.valueOf(1000);
            BankAccount bankAccount = new BankAccount(1L, initialBalance);
            repository.save(bankAccount);
        };
    }

}
