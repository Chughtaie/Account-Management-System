package com.chughtai;

import java.text.SimpleDateFormat;
import java.util.Date;


abstract class Account {

    Customer customer;
    boolean type;
    boolean active;
    final public String account_no;
    String date_created;
    double balance;

    public Account(String num) {
        customer = new Customer(num);
        account_no = num;
        active=true;
        balance=0;

        Date dat = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        date_created= formatter.format(dat);
    }
    public Account() {
        super();
        customer = new Customer();
        account_no = Integer.toString(customer.ID) + "_" +customer.name;
        active=true;
        balance=0;

        Date dat = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        date_created= formatter.format(dat);
    }

    void checkBalance(){
        System.out.println("Your balance = " + balance);
        //System.out.println("The balance in Account # " + account_no + " = " + balance);
    }

   abstract double makeWithdrawal(double amount);

    void printStatement() {

    }

    void makeDeposit(double add) {
        balance+=add;
        checkBalance();
    }
    void transferAmount(String account, double transfer) {
        if(balance>transfer)
        {
            balance-=transfer;
            System.out.println("Amount transferred!");
        }
        else
            System.out.println("You don't have enough balance!");

        checkBalance();
    }


}

class SavingAccount extends Account{

    SavingAccount(){
        type = true;
    }
    SavingAccount(String abc){
        super(abc);
        type=true;
    }
    static float interest_rate=0;
    double calculateZakat() {
        if(balance>=20_000){
            double zakat = (balance*2.5)/100;
            System.out.println("Payable Zakat = " + zakat);
            return zakat;
        }
        System.out.println("Zakat is not mandatory for this amount!");
        return 0.0;
    }

    double makeWithdrawal(double amount) {

        if(balance>=amount) {
            balance -= amount;
            System.out.println("Money Withdrawed!");
        }else System.out.println("You don;t have much balance!");

        checkBalance();
        return balance;
    }
    double calculateInterest(){
        double rate = balance*(interest_rate/100);
        System.out.println("Current Interest @"+ interest_rate + "% = " + rate);
        return rate;
    }
}


class Checking_Account extends Account{

    double haram = 5_000.0;
    int Transaction = 0;

    Checking_Account(){
        type=false;
    }
    Checking_Account(String abc){
        super(abc);
        type=false;
    }

    double  makeWithdrawal(double amount) {
        if(balance+haram>=amount) {
            balance -= amount;
            System.out.println("Money Withdrawed!");
        }else System.out.println("You don;t have much balance!");

        checkBalance();
        return balance;
    }
}

