package com.Chathumina.core;

import com.Chathumina.lib.Transaction;

public class Grandmother extends Thread {
    private String gName;
    private CurrentBankAccount currentBankAccount;

    public Grandmother(ThreadGroup group, String name, CurrentBankAccount currentBankAccount) {
        super(group, name);
        this.gName = name;
        this.currentBankAccount = currentBankAccount;
    }

    public void birthdayTopup(){
        Transaction birthdayGift = new Transaction(this.gName, 5000);
        currentBankAccount.deposit(birthdayGift);
//        System.out.println("{Grandmother}: Deposit transaction for : " + birthdayGift);
        try {
            sleep( (int)(Math.random() * 100) ) ;
        }
        catch (InterruptedException e) { }
    }

    public void christmasTopup(){
        Transaction christmasGift = new Transaction(this.gName, 3000);
        currentBankAccount.deposit(christmasGift);
//        System.out.println("{Grandmother}: Deposit transaction for : " + christmasGift);
        try {
            sleep( (int)(Math.random() * 100) ) ;
        }
        catch (InterruptedException e) { }
    }

    @Override
    public void run() {
        System.out.println("---Transactions Started by Grandmother---");
        birthdayTopup();
        christmasTopup();
        System.out.println("---Transactions Terminated by Grandmother---");
    }
}
