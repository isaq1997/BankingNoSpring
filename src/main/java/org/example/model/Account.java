package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.exceptions.InsufficientFundException;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class Account {
    private String accountNo;
    private BigDecimal amount;
    private String customerName;

    public Account(String accountNo, BigDecimal amount, String customerName) {
        this.accountNo = accountNo;
        this.amount = amount;
        this.customerName = customerName;
    }
    public void withdraw (BigDecimal amount){
         if (this.amount.compareTo(amount)<0 ) throw  new InsufficientFundException("Not Enough Money");
         this.amount=this.amount.subtract(amount);
    }
    public void deposit (BigDecimal amount){
        this.amount = this.amount.add(amount);
    }


}
