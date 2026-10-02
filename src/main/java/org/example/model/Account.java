package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.exceptions.InsufficientFundException;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@ToString
public class Account {
    private final String accountNo;
    private BigDecimal amount;
    private final String customerName;

    public Account(String accountNo, BigDecimal amount, String customerName) {
        this.accountNo = accountNo;
        this.amount = amount;
        this.customerName = customerName;
    }
    public void withdraw (BigDecimal amount){
         requirePositive(amount);
         if (this.amount.compareTo(amount)<0 ) {
             throw new InsufficientFundException("Not Enough Money");
         }
        this.amount=this.amount.subtract(amount);
    }
    public void deposit (BigDecimal amount){
        requirePositive(amount);
        this.amount = this.amount.add(amount);
    }
    private static void requirePositive(BigDecimal amount) {
        Objects.requireNonNull(amount, "amount must not be null");
        if (amount.signum() <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }


}
