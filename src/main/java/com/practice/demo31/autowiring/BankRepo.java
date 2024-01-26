package com.practice.demo31.autowiring;

public interface BankRepo {
    int createAccount(String name);
    double getBalance(int accountId);
    void updateBalance(int accountId, double balance);
    void deleteAccount(int accountId);
}
