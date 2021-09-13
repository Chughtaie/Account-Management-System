package com.chughtai;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Admin {
    String name;
    double salary;
    Date start_Date;

    Account openAccount() throws IOException {
        System.out.println("\n1. Saving Account\n2. Checking Account\n");
        Scanner scan = new Scanner(System.in);
        byte inp = scan.nextByte();
        Account acc ;
        if(inp==1) {
            acc=new SavingAccount();
        }
        else if (inp==2) {
           acc = new Checking_Account();
        }
        else
           acc = new SavingAccount();


        File myFile=new File("Record.txt");
        if(!myFile.exists())
        try{
            myFile.createNewFile();
        }catch (IOException e){
            System.out.println("Unable to open file");
        }
        if(myFile.exists()) {
            FileWriter file = new FileWriter("Record.txt",true);
            file.write(acc.account_no+' '+acc.type+' '+acc.active+' '+acc.balance+' '+acc.date_created+' '+acc.customer.name+' '+acc.customer.address+' '+acc.customer.phone+' '+acc.customer.ID+'\n');
            file.close();
        }
        return acc;
    }
    Account closeAccount(Account acc){
        acc.active=false;
        return acc;
    }
    Account Login() throws FileNotFoundException {

        System.out.println("Enter Account Number : ");
        Scanner log = new Scanner(System.in);
        String inp = new String();
        String numb=new String();
        inp = log.next();


        File myFile=new File("Record.txt");
        Scanner scan;
        scan = new Scanner(myFile);

        Account acc = null;

        while(scan.hasNextLine()){

            numb = scan.next();
            String line = scan.nextLine();

            System.out.println(numb+'-'+inp);

            if(inp.equals(numb)) {

                StringTokenizer tk= new StringTokenizer(line);
                boolean type= Boolean.parseBoolean(tk.nextToken());

                if(type==true)
                    acc=new SavingAccount(numb);
                else
                    acc=new Checking_Account(numb);


                System.out.println(line);


                //type=Boolean.parseBoolean(tk.nextToken());
                acc.active = Boolean.parseBoolean(tk.nextToken());
                acc.balance=Double.parseDouble(tk.nextToken());
                acc.date_created = tk.nextToken();
                acc.customer.name = tk.nextToken();
                acc.customer.address = tk.nextToken();
                acc.customer.phone = Integer.parseInt(tk.nextToken());
                acc.customer.ID = Integer.parseInt(tk.nextToken());

            }else System.out.println("Account does not exist!");
        }
        return acc;
    }
    AccountnOperations
}
