package com.Chathumina.core;

import com.Chathumina.lib.BankAccount;
import com.Chathumina.lib.Statement;
import com.Chathumina.lib.Transaction;

public class CurrentBankAccount implements BankAccount {
    private String cusId;
    private int bankAccountNumber;
    private Statement statement;
    private int accountBalance;

    public CurrentBankAccount(String cusId, int bankAccountNumber, int accountBalance) {
        this.cusId = cusId;
        this.bankAccountNumber = bankAccountNumber;
        this.statement = new Statement(cusId, bankAccountNumber);
        this.accountBalance = accountBalance;
    }

    @Override
    public int getBalance() {
        return this.accountBalance;
    }

    @Override
    public int getAccountNumber() {
        return this.bankAccountNumber;
    }

    @Override
    public String getAccountHolder() {
        return this.cusId;
    }

    @Override
    public synchronized void deposit(Transaction t) {
        int depositAmount = t.getAmount();
        this.accountBalance += depositAmount;
        this.statement.addTransaction(t.getCID(), depositAmount, this.accountBalance);
        notifyAll();
    }

    @Override
    public synchronized void withdrawal(Transaction t) {
        int withdrawAmount = t.getAmount();
        while (withdrawAmount > this.accountBalance) {
            try {
                System.out.println("{CurrentBankAccount}: Cannot withdraw requested amount of " + withdrawAmount + " by " + t.getCID() +
                        ". Waiting until requested amount is available...");
                wait();
            } catch (InterruptedException e) {
            }
        }

        this.accountBalance -= withdrawAmount;
        this.statement.addTransaction(t.getCID(), withdrawAmount, this.accountBalance);
    }

    @Override
    public boolean isOverdrawn() {
        return this.accountBalance < 0;
    }

    @Override
    public void printStatement() {
        this.statement.print();
    }
}
