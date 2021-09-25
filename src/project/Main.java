package project;
import java.io.IOException;
import java.util.Scanner;


public class Main {


    
    
	static void check(int inp,Account acc) throws IOException {
		
        Admin admin=new Admin();

        if(inp==0)
            return;
        else if (inp == 1) {
            acc = admin.openAccount();
            //if (Acc.account_no.charAt(0) == 'S')
              //  acc=acc;
            //else
              //  acc=acc;
        }
        else if(inp > 1 && inp < 5) {
        	
        	if(acc==null)
        		acc = admin.Login();
        	
        	if(acc==null) {System.out.println("\nNo Account Found!!\n"); return;}
            
        	if (inp==2) {
                admin.closeAccount(acc);
                acc=null;
        	}
        	else if(inp == 4)
        		admin.Operations(acc);
        }
        else if(inp == 5)
    		admin.InterestRate();
        else System.out.println("\nInvalid Input!!\n");
	}
	
	
    public static void main(String[] args) throws IOException  {
        Admin admin = new Admin();
        Account acc=null;
         int inp;
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
            inp = scan.nextInt();
            if(inp==0) return;
            check(inp,acc);

            /*
            Account [][] acc = new Account[2][];
            int cn=0;
            int sn=0;
             acc[0] = new SavingAccount[10];
             acc[1] = new CheckingAccount[10];

            int tot=0;
            */
            

   

        }
    }

    int sn = 0;
}
