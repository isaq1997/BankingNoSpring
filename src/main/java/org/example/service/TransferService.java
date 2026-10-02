package org.example.service;

import org.example.model.Transaction;

import java.math.BigDecimal;

public interface TransferService {
    Transaction transfer(String fromId, String toId, BigDecimal amount);
}
