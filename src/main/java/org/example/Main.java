package org.example;

import org.example.model.Account;
import org.example.model.Transaction;
import org.example.repository.AccountRepository;
import org.example.repository.AccountRepositoryImpl;
import org.example.repository.TransactionRepository;
import org.example.repository.TransactionRepositoryImpl;
import org.example.service.TransferService;
import org.example.service.TransferServiceImpl;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Account accountFrom = new Account("388813",new BigDecimal("30"),"Joe");
        Account accountTo = new Account("388815",new BigDecimal("50"),"Reda");

        AccountRepository accountRepository= new AccountRepositoryImpl();

        accountRepository.save(accountFrom);
        accountRepository.save(accountTo);
        System.out.println(accountRepository.findAll());
        TransferService transferService= new TransferServiceImpl(accountRepository);
        System.out.println(accountRepository.findAll());


        Transaction t=transferService.transfer(accountFrom.getAccountNo(),accountTo.getAccountNo(),new BigDecimal("130"));
        System.out.println(t.status());

        TransactionRepository transactionRepository= new TransactionRepositoryImpl();
        transactionRepository.save(t);
        System.out.println(t.toString());

        System.out.println();

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }
}