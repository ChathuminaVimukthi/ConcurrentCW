package com.Chathumina;

import com.Chathumina.core.*;

public class BankingSystem {

    Student student;
    Grandmother grandmother;
    StudentLoanCompany loanCompany;
    University university;
    CurrentBankAccount currentBankAccount;

    ThreadGroup humans;
    ThreadGroup companies;

    public BankingSystem() {
        this.humans = new ThreadGroup("Humans");
        this.companies = new ThreadGroup("Companies");
        this.currentBankAccount = new CurrentBankAccount("ChathuminaV", 102010, 0);
        this.student = new Student(humans, currentBankAccount.getAccountHolder(), currentBankAccount);
        this.grandmother = new Grandmother(humans, "Grand Ma", currentBankAccount);
        this.loanCompany = new StudentLoanCompany(companies, "NTB", currentBankAccount);
        this.university = new University(companies, "IIT", currentBankAccount);
    }

    public static void main(String[] args) {
        // write your code here
        BankingSystem bSystem = new BankingSystem();
        bSystem.student.start();
        bSystem.grandmother.start();
        bSystem.loanCompany.start();
        bSystem.university.start();

        try{
            bSystem.student.join();
            bSystem.grandmother.join();
            bSystem.loanCompany.join();
            bSystem.university.join();
        }catch (InterruptedException e){ }

        bSystem.currentBankAccount.printStatement();
    }
}
