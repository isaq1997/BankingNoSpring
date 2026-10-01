package org.example.repository;

import org.example.model.Account;

import java.util.Collection;

public interface AccountRepository {
    void save(Account account);
    Account findById(String id);          // throws AccountNotFoundException
    Collection<Account> findAll();
}
