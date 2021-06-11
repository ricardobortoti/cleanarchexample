package com.example.cleanarchexample.adapters.persistence.repository;

import com.example.cleanarchexample.application.domain.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataBankAccountRepository extends JpaRepository<BankAccount, Long> { }
