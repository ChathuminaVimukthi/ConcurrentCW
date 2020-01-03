package com.Chathumina.core;

import com.Chathumina.lib.Transaction;

public class Student extends Thread {
    private String stName;
    private CurrentBankAccount currentBankAccount;

    public Student(ThreadGroup group, String name, CurrentBankAccount currentBankAccount) {
        super(group, name);
        this.stName = name;
        this.currentBankAccount = currentBankAccount;
    }

    public void payInternetBill(){
        Transaction internetBill = new Transaction(this.stName, 3000);
        currentBankAccount.withdrawal(internetBill);
        System.out.println("{Student}: Withdrawal transaction for : " + internetBill);
        try {
            sleep( (int)(Math.random() * 100) ) ;
        }
        catch (InterruptedException e) { }
    }

    public void payPhoneBill(){
        Transaction phoneBill = new Transaction(this.stName, 1000);
        currentBankAccount.withdrawal(phoneBill);
        System.out.println("{Student}: Withdrawal transaction for : " + phoneBill);
        try {
            sleep( (int)(Math.random() * 100) ) ;
        }
        catch (InterruptedException e) { }
    }

    public void payForShopping(){
        Transaction shoppingBill = new Transaction(this.stName, 6000);
        currentBankAccount.withdrawal(shoppingBill);
        System.out.println("{Student}: Withdrawal transaction for : " + shoppingBill);
        try {
            sleep( (int)(Math.random() * 100) ) ;
        }
        catch (InterruptedException e) { }
    }

    public void winLottery(){
        Transaction winLottery = new Transaction(this.stName, 10000);
        currentBankAccount.deposit(winLottery);
        System.out.println("{Student}: Deposit transaction for : " + winLottery);
        try {
            sleep( (int)(Math.random() * 100) ) ;
        }
        catch (InterruptedException e) { }
    }

    public void depositCash(){
        Transaction savingsDeposit = new Transaction(this.stName, 2000);
        currentBankAccount.deposit(savingsDeposit);
        System.out.println("{Student}: Deposit transaction for : " + savingsDeposit);
        try {
            sleep( (int)(Math.random() * 100) ) ;
        }
        catch (InterruptedException e) { }
    }

    public void anotherDeposit(){
        Transaction anotherDeposit = new Transaction(this.stName, 500);
        currentBankAccount.deposit(anotherDeposit);
        System.out.println("{Student}: Deposit transaction for : " + anotherDeposit);
        try {
            sleep( (int)(Math.random() * 100) ) ;
        }
        catch (InterruptedException e) { }
    }

    @Override
    public void run() {
        System.out.println("---Transactions Started by Student---");
        payInternetBill();
        payPhoneBill();
        payForShopping();
        winLottery();
        depositCash();
        anotherDeposit();

        currentBankAccount.printStatement();

        System.out.println("---Transactions Terminated by Student---");
    }
}
