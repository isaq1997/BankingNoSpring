package org.example.service;

import org.example.exceptions.AccountNotFoundException;
import org.example.exceptions.InsufficientFundException;
import org.example.model.Account;
import org.example.model.Transaction;
import org.example.repository.AccountRepository;
import org.example.repository.AccountRepositoryImpl;

import java.math.BigDecimal;

public class TransferServiceImpl  implements TransferService{
    private final AccountRepository accountRepository;

    public TransferServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }    @Override
    public Transaction transfer(String fromId, String toId, BigDecimal amount) {
try {
    Account fromAcc = accountRepository.findById(fromId);
    Account toAcc = accountRepository.findById(toId);
    makePayment(fromAcc, toAcc, amount);
    return Transaction.success(fromId, toId, amount);
}catch (InsufficientFundException | AccountNotFoundException e) {
    return Transaction.failed(fromId, toId, amount, e.getMessage());
}
    }

    public void makePayment(Account accountFrom,Account accountTo,BigDecimal amount){
        accountFrom.withdraw(amount);
        accountTo.deposit(amount);
    }
}
