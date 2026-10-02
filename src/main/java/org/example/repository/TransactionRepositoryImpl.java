package org.example.repository;

import org.example.exceptions.AccountNotFoundException;
import org.example.exceptions.TransactionNotFoundException;
import org.example.model.Account;
import org.example.model.Transaction;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionRepositoryImpl implements TransactionRepository{
    private final Map<String, Transaction> store = new ConcurrentHashMap<>();


    @Override
    public Transaction findById(String id) {
        Transaction t = store.get(id);
        if (t == null) throw new TransactionNotFoundException(id);
        return t;
    }

    @Override public Collection<Transaction> findAll() {
        return List.copyOf(store.values());
    }

    @Override
    public void save(Transaction transaction)
    { store.put(transaction.id(), transaction); }

}
