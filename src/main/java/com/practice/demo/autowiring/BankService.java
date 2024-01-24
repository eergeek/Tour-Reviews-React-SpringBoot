package com.practice.demo.autowiring;

public interface BankService {
    void deposit(int accountId, double amount);
    void withdraw(int accountId, double amount);
    void transfer(int fromAccountId, int toAccountId, double amount);
}
