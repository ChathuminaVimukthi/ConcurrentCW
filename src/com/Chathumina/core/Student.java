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

    public void makeTransaction(String type, int amount){
        Transaction internetBill = new Transaction(this.stName, amount);
        if(type.equalsIgnoreCase("add")){
            currentBankAccount.deposit(internetBill);
//            System.out.println("{Student}: Deposit transaction for : " + internetBill);
        }else{
            currentBankAccount.withdrawal(internetBill);
//            System.out.println("{Student}: Withdrawal transaction for : " + internetBill);
        }
        try {
            sleep( (int)(Math.random() * 100) ) ;
        }
        catch (InterruptedException e) { }
    }

    @Override
    public void run() {
        System.out.println("---Transactions Started by Student---");
        makeTransaction("subtract", 3000);
        makeTransaction("subtract", 1000);
        makeTransaction("subtract", 6000);
        makeTransaction("add", 10000);
        makeTransaction("add", 2000);
        makeTransaction("add", 500);

        //currentBankAccount.printStatement();

        System.out.println("---Transactions Terminated by Student---");
    }
}
