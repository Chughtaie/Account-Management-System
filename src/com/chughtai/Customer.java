package com.chughtai;

import java.util.Scanner;

public class Customer {
    String name;
    String address;
    int phone;
    int ID;

        Customer(String id){
            name="";
            address="";
            phone=0;
            ID=0;
        }
    Customer(){
            Scanner cust = new Scanner(System.in);
        System.out.println("\nEnter Customer Name :  ");
        name = cust.nextLine();
        System.out.println("\nEnter Customer address :  ");
        address= cust.nextLine();
        System.out.println("\nEnter Customer Phone Number :  ");
        phone= cust.nextInt();
        System.out.println("\nEnter Customer National_ID :  ");
        ID=cust.nextInt();
    }

}
