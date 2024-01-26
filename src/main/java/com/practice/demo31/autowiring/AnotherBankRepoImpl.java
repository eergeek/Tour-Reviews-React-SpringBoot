package com.practice.demo31.autowiring;

import org.springframework.stereotype.Component;

@Component("anotherBankRepo")
public class AnotherBankRepoImpl implements BankRepo {
    @Override
    public int createAccount(String name) {
        return 0;
    }

    @Override
    public double getBalance(int accountId) {
        return 0;
    }

    @Override
    public void updateBalance(int accountId, double balance) {

    }

    @Override
    public void deleteAccount(int accountId) {

    }

    @Override
    public String toString() {
        return "AnotherBankRepoImpl{}";
    }
}
