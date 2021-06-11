package com.example.cleanarchexample.adapters.configuration;

import com.example.cleanarchexample.CleanarchexampleApplication;
import com.example.cleanarchexample.adapters.persistence.repository.BankAccountRepository;
import com.example.cleanarchexample.application.services.BankAccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CleanarchexampleApplication.class)
public class BeanConfiguration {

    @Bean
    BankAccountService bankAccountService(BankAccountRepository repository) {
        return new BankAccountService(repository, repository);
    }
}
