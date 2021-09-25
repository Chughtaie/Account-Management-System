package project;

import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class Account<virtual> {

    Customer customer;
    protected boolean type;
    protected boolean active;
    public String account_no;
    String date_created;
    protected double balance;

    public Account(String num) {
        customer = new Customer(num);
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

    double checkBalance(){
        System.out.println("Your balance = " + balance);
        //System.out.println("The balance in Account # " + account_no + " = " + balance);
        return balance;
    }


    double calculateZakat() {
    	System.out.println("Zakat is not calculated for this account type!!");
    	return 0.0;
    }

    double calculateInterest(){
    	System.out.println("Interest is not calculated for this account type!!");
    	return 0.0;
    	
    }
    void printStatement() {
        System.out.println("Your Bank Statement: " );
    }

    double makeDeposit(double add) {
        balance+=add;
        checkBalance();
        return balance;
    }
    double transferAmount(Account account, double transfer) {
    	
        if(balance>=transfer)
        {
            balance-=transfer;
            account.balance+=transfer;
            System.out.println("Amount transferred!");
        }
        else
            System.out.println("You don't have enough balance!");

        checkBalance();
        return balance;
    }


    abstract double makeWithdrawal(double amount);
}


