package com.practice.demo.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class BankServiceImpl implements BankService {

    @Autowired(required = true)
    @Qualifier("basicBankRepo")
    BankRepo bankRepo;

    @Autowired
    Collection<BankRepo> bankRepos;

    @Autowired
    Map<String, BankRepo> bankRepoMap;  // Key is Bean Name

    public void mapInjectionAutowire() {
        System.out.println("Collection ");
        for (BankRepo bankrepo :
                bankRepos) {
            System.out.println(bankrepo);
        }

        System.out.println("String -> Value Map");
        bankRepoMap.forEach((bankRepoKey, bankRepoValue) ->
                System.out.printf("Key %s -> Value %s\n", bankRepoKey, bankRepoValue));
    }

    @Override
    public void deposit(int accountId, double amount) {
        System.out.printf("Service Deposit:: Account %d -> Money %f\n", accountId, amount);
        bankRepo.updateBalance(accountId, amount);
    }

    @Override
    public void withdraw(int accountId, double amount) {
        System.out.printf("Service Withdraw:: Account %d -> Money %f\n", accountId, amount);
        bankRepo.updateBalance(accountId, amount);
        bankRepo.getBalance(accountId);
    }

    @Override
    public void transfer(int fromAccountId, int toAccountId, double amount) {
        System.out.printf("Service Transfer:: From Account %d\n" +
                "To Account: %d\n" +
                "Money %f\n", fromAccountId, toAccountId, amount);

        bankRepo.getBalance(fromAccountId);
        bankRepo.getBalance(toAccountId);
    }
}
