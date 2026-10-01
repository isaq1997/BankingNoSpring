package org.example.repository;

import org.example.exceptions.AccountNotFoundException;
import org.example.model.Account;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AccountRepositoryImpl implements AccountRepository {
    private final Map<String, Account> store = new ConcurrentHashMap<>();

    @Override
    public void save(Account account) { store.put(account.getAccountNo(), account); }

    @Override
    public Account findById(String id) {
        Account a = store.get(id);
        if (a == null) throw new AccountNotFoundException(id);
        return a;
    }

    @Override public Collection<Account> findAll() { return store.values(); }
}
