package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.exceptions.InsufficientFundException;

@Getter
@Setter
@ToString
public class Account {
    private String accountNo;
    private double amount;
    private String customerName;

    public Account(String accountNo, double amount, String customerName) {
        this.accountNo = accountNo;
        this.amount = amount;
        this.customerName = customerName;
    }
    public void withdraw (double amount){
         if (this.amount<amount ) throw  new InsufficientFundException("Not Enough Money");
         this.amount=this.amount-amount;
    }
    public void deposit (double amount){
        this.amount=this.amount+amount;

    }


}
