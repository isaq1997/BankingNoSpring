package org.example.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public record Transaction(String id, String fromId, String toId, double amount,
                          TransactionStatus status, String reason, Instant timestamp)
{
    public static Transaction success(String from, String to, double amount) {
        return new Transaction(UUID.randomUUID().toString(), from, to, amount,
                TransactionStatus.SUCCESS, "OK", Instant.now());
    }

    public static Transaction failed(String from, String to, double amount, String reason) {
        return new Transaction(UUID.randomUUID().toString(), from, to, amount,
                TransactionStatus.FAILED, reason, Instant.now());
    }
}
