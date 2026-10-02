package org.example.repository;

import org.example.model.Account;
import org.example.model.Transaction;

import java.util.Collection;

public interface TransactionRepository {
    Transaction findById(String id);          // throws AccountNotFoundException
    Collection<Transaction> findAll();
    void save(Transaction transaction);


}
