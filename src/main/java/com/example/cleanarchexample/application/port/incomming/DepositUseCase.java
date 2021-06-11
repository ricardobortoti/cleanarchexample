package com.example.cleanarchexample.application.port.incomming;

import java.math.BigDecimal;

public interface DepositUseCase {
    void deposit(Long id, BigDecimal amount);
}
