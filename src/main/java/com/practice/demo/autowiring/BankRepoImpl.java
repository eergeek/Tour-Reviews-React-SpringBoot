package com.practice.demo.autowiring;

import org.springframework.stereotype.Repository;

@Repository("basicBankRepo")
public class BankRepoImpl implements BankRepo {
    @Override
    public int createAccount(String name) {
        System.out.println("Create Account" + name);
        return 0;
    }

    @Override
    public double getBalance(int accountId) {
        System.out.println("Read Balance for Account " + accountId);
        return 0;
    }

    @Override
    public void updateBalance(int accountId, double balance) {
        System.out.println("Update Balance:: AccountId: " + accountId + " Balance: " + balance );
    }

    @Override
    public void deleteAccount(int accountId) {
        System.out.println("Delete Account: " + accountId);
    }

    @Override
    public String toString() {
        return "BankRepoImpl{}";
    }
}
