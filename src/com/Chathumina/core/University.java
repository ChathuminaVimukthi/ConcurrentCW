package com.Chathumina.core;

import com.Chathumina.lib.Transaction;

public class University extends Thread {
    private String uName;
    private CurrentBankAccount currentBankAccount;

    public University(ThreadGroup group, String name, CurrentBankAccount currentBankAccount) {
        super(group, name);
        this.uName = name;
        this.currentBankAccount = currentBankAccount;
    }

    @Override
    public void run() {
        System.out.println("---Transactions Started by University---");
        for (int i = 0; i < 3; i++){
            Transaction universityWithdraw = new Transaction(this.uName, 15000);
            currentBankAccount.withdrawal(universityWithdraw);
            System.out.println("{University}: Withdrawal transaction for : " + universityWithdraw);
            try {
                sleep( (int)(Math.random() * 100) ) ;
            }
            catch (InterruptedException e) { }
        }
        System.out.println("---Transactions Terminated by University---");
    }
}
