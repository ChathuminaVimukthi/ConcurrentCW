package com.Chathumina.core;

import com.Chathumina.lib.Transaction;

public class StudentLoanCompany extends Thread {
    private String companyName;
    private CurrentBankAccount currentBankAccount;

    public StudentLoanCompany(ThreadGroup group, String name, CurrentBankAccount currentBankAccount) {
        super(group, name);
        this.companyName = name;
        this.currentBankAccount = currentBankAccount;
    }

    @Override
    public void run() {
        System.out.println("---Transactions Started by Loan Company---");
        for (int i = 0; i < 3; i++){
            Transaction loanCompanyDeposit= new Transaction(this.companyName, 20000);
            currentBankAccount.deposit(loanCompanyDeposit);
            System.out.println("{LoanCompany}: Deposit transaction for : " + loanCompanyDeposit);
            try {
                sleep( (int)(Math.random() * 100) ) ;
            }
            catch (InterruptedException e) { }
        }
        System.out.println("---Transactions Terminated by Loan Company---");
    }
}
