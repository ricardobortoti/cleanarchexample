package com.example.cleanarchexample.application.services;

import com.example.cleanarchexample.application.domain.BankAccount;
import com.example.cleanarchexample.application.port.incomming.DepositUseCase;
import com.example.cleanarchexample.application.port.incomming.WithdrawUseCase;
import com.example.cleanarchexample.application.port.outgoing.LoadAccountPort;
import com.example.cleanarchexample.application.port.outgoing.SaveAccountPort;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

public class BankAccountService implements DepositUseCase, WithdrawUseCase {

    private LoadAccountPort loadAccountPort;
    private SaveAccountPort saveAccountPort;

    public BankAccountService(LoadAccountPort loadAccountPort, SaveAccountPort saveAccountPort) {
        this.loadAccountPort = loadAccountPort;
        this.saveAccountPort = saveAccountPort;
    }

    @Override
    public void deposit(Long id, BigDecimal amount) {
        BankAccount account = loadAccountPort.load(id).orElseThrow(NoSuchElementException::new);

        account.deposit(amount);

        saveAccountPort.save(account);
    }

    @Override
    public boolean withdraw(Long id, BigDecimal amount) {
        BankAccount account = loadAccountPort.load(id).orElseThrow(NoSuchElementException::new);

        boolean hasWithdrawn = account.withdraw(amount);

        if (hasWithdrawn) {
            saveAccountPort.save(account);
        }

        return hasWithdrawn;
    }
}
