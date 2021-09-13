package com.chughtai;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Admin admin = new Admin();
        byte inp;
        while(true) {
            System.out.println(
                    """

                            0. Exit
                            1. Open Account
                            2. Close Account
                            3. Login
                            4. Operations
                            5. Interest Rate
                            6. Display Accounts Details
                            7. Display Accounts Deductions
                            """);

            Scanner scan = new Scanner(System.in);
            inp = scan.nextByte();

            Account acc=null;
            if(inp==0)
                break;
            else if (inp == 1)
                acc = admin.openAccount();
            else if(inp == 2) {
                acc = admin.Login();
                if (acc != null)
                    acc = admin.closeAccount(acc);
            }
            else if(inp == 3)
               acc =  admin.Login();
            else if(inp == 4)
                acc == Operations();


        }
    }
}
