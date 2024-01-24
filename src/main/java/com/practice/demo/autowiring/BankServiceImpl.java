package com.practice.demo.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {

    @Autowired(required = false)
    @Qualifier("myBank")
    BankRepo bankRepo;

    @Override
    public void deposit(int accountId, double amount) {
        System.out.printf("Service Deposit:: Account %d -> Money %f", accountId, amount);
    }

    @Override
    public void withdraw(int accountId, double amount) {
        System.out.printf("Service Withdraw:: Account %d -> Money %f", accountId, amount);
    }

    @Override
    public void transfer(int fromAccountId, int toAccountId, double amount) {
        System.out.printf("Service Transfer:: From Account %d\n" +
                "To Account: %d\n" +
                "Money %f", fromAccountId, toAccountId, amount);
    }
}
