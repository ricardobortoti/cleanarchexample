package com.example.cleanarchexample.application.port.outgoing;

import com.example.cleanarchexample.application.domain.BankAccount;

import java.util.Optional;

public interface LoadAccountPort {
    Optional<BankAccount> load(Long id);
}
