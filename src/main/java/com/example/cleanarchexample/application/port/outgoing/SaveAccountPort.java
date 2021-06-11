package com.example.cleanarchexample.application.port.outgoing;

import com.example.cleanarchexample.application.domain.BankAccount;

public interface SaveAccountPort {
    void save(BankAccount bankAccount);
}
