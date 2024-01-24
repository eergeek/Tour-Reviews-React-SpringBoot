package com.practice.demo.autowiring;

import org.springframework.stereotype.Component;

public interface BankRepo {
    int createAccount(String name);
    double getBalance(int accountId);
    void updateBalance(int accountId, double balance);
    void deleteAccount(int accountId);
}
