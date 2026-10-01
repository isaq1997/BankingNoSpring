package org.example;

import org.example.model.Account;
import org.example.model.Transaction;
import org.example.repository.AccountRepository;
import org.example.repository.AccountRepositoryImpl;
import org.example.service.TransferService;
import org.example.service.TransferServiceImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Account accountFrom = new Account("388813",30,"Joe");
        Account accountTo = new Account("388815",50,"Reda");

        AccountRepository accountRepository= new AccountRepositoryImpl();

        accountRepository.save(accountFrom);
        accountRepository.save(accountTo);
        System.out.println(accountRepository.findAll());
        TransferService transferService= new TransferServiceImpl(accountRepository);
        System.out.println(accountRepository.findAll());


        Transaction t=transferService.transfer(accountFrom.getAccountNo(),accountTo.getAccountNo(),230);
        System.out.println(t.status());



        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }
}