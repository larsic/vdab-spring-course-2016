package com.realdolmen.spring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class Bank {
    @Autowired
    private AccountRepository repository;

    public Account openAccount(Account account) {
        System.out.println("Opening account " + account.getName() + " with balance €" + account.getBalance());
        repository.save(account);
        return account;
    }

    public Account transfer(BigDecimal amount, Account from, Account to) {
        System.out.format("Transfering €%s from account '%s' to '%s'%n", amount.toString(), from.getName(), to.getName());

        from.setBalance(from.getBalance().subtract(amount));
        repository.save(from);

        Bug.causeMischief("i like it");

        to.setBalance(to.getBalance().add(amount));
        return repository.save(to);
    }

    public Account transfer(BigDecimal amount, Account to) {
        System.out.format("Transfering €%s externally to '%s'%n", amount.toString(), to.getName());
        to.setBalance(to.getBalance().add(amount));
        return repository.save(to);
    }

    public void printAccounts() {
        List<Account> accounts = repository.findAll();
        accounts.forEach(Account::print);
        BigDecimal total = accounts.stream().map(Account::getBalance).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total money: " + total);
    }
}
