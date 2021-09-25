package project;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Admin {
    String name;
    double salary;
    Date start_Date;
    
    void Save(Account acc) throws IOException {
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
    }
    
    void Append(Account acc) throws IOException{
    	
    String newString = (acc.account_no+' '+acc.type+' '+acc.active+' '+acc.balance+' '+acc.date_created+
    		' '+acc.customer.name+' '+acc.customer.address+' '+acc.customer.phone+' '+acc.customer.ID+'\n');
    File myFile = new File("Record.txt");
    // An array to store each line in the file
    ArrayList<String> fileContent = new ArrayList<String>();
    Scanner myReader = new Scanner(myFile);
    while (myReader.hasNextLine()) {
        // Reads the file content into an array
        fileContent.add(myReader.nextLine());
    }
    myReader.close();

    // Writes the new content to file
    FileWriter myWriter = new FileWriter("Record.txt");
    for (String eachLine : fileContent) {
    	if(eachLine.startsWith(acc.account_no)) {
    		eachLine="\0";
    		eachLine=newString;
    		
    	    }
        myWriter.write(eachLine + "\n");
    }
    myWriter.close();


    }

    Account openAccount() throws IOException {
    	
        System.out.println("\n1. Saving Account\n2. Checking Account\n");
        Scanner scan = new Scanner(System.in);
        byte inp = scan.nextByte();
        Account acc ;
        if(inp==1) {
            acc = new SavingAccount();
        }
        else if (inp==2) {
            acc = new CheckingAccount();
        }
        else
            return null;


        Save(acc);
        System.out.println("Account Created\n");
        
        return acc;
    }

    void closeAccount(Account acc) throws IOException{
        acc.active=false;
        System.out.println("Account Closed\n");
        Append(acc);
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

            //System.out.println(numb+'-'+inp);

            if(inp.equals(numb)) {

                StringTokenizer tk= new StringTokenizer(line);
                boolean type= Boolean.parseBoolean(tk.nextToken());

                if(type==true)
                    acc=new SavingAccount(numb);
                else
                    acc=new CheckingAccount(numb);


               //System.out.println(line);


                //type=Boolean.parseBoolean(tk.nextToken());
                acc.active = Boolean.parseBoolean(tk.nextToken());
                acc.balance = Double.parseDouble(tk.nextToken());
                acc.date_created = tk.nextToken();
                acc.customer.name = tk.nextToken();
                acc.customer.address = tk.nextToken();
                acc.customer.phone = Integer.parseInt(tk.nextToken());
                acc.customer.ID = Integer.parseInt(tk.nextToken());

                
                
            }
        }
        
        if(acc.active==false) { System.out.println("Account is deactivated\n"); return null;}        
        if(acc!=null) System.out.println("Logged in\n"); 
        else System.out.println("Account does not exist!");
        //System.out.print(acc.balance);
        return acc;
    }


double deposit(Account acc) throws IOException {
    	
    	System.out.println("Enter amount to deposit!!\n");
    	Scanner scan = new Scanner(System.in);
        double dep = scan.nextDouble();
        
    	acc.makeDeposit(dep);
    	
    	Append(acc);
    	return acc.balance;
    }
    
double withdraw(Account acc) throws IOException {
    	
    	System.out.println("Enter amount to withdraw!!\n");
    	Scanner scan = new Scanner(System.in);
        double with = scan.nextDouble();
        
    	acc.makeWithdrawal(with);
    	Append(acc);
    return acc.balance;	
    }
double balance(Account acc) {
	acc.checkBalance();
	return acc.balance;
}

void statement(Account acc) {
	
	
	
}

double transfer(Account acc) throws FileNotFoundException,IOException {
	Account transfer=null;
	transfer = Login();
	if(transfer==null) if(acc==null) {System.out.println("\nNo Account Found!!\n"); return 0.0;}
    
	System.out.println("Enter amount to transfer!!\n");
	Scanner scan = new Scanner(System.in);
    double dep = scan.nextDouble();
    
		acc.transferAmount(transfer, dep);
		Append(acc);
		Append(transfer);
		return acc.balance;
	
}
    
void deductions(Account acc) {
	
	
	
}

double zakat(Account acc) {
	return acc.calculateZakat();
	
}


double interest(Account acc) {
	return acc.calculateInterest();	
}


void Ops(byte inp,Account acc) throws FileNotFoundException,IOException { 
    	
    	Admin admin = new Admin();
    	
    	if(inp==1) admin.deposit(acc);
    		else if (inp==2) admin.withdraw(acc);
    			else if (inp==3) admin.balance(acc);
    				else if (inp==4) admin.statement(acc);
    					else if (inp==5) admin.transfer(acc);
    						else if (inp==6) admin.deductions(acc);
    							else if (inp==7) admin.zakat(acc);
    								else if (inp==8) admin.interest(acc);
    							    	
    				    		
    }
	

	public void Operations(Account acc) throws FileNotFoundException,IOException {
		// TODO Auto-generated method stub
		byte inp;
		
	   // while(true)
		{
	    	
	        System.out.println(
	                """
	                        0. Exit
	                        1. Deposit 
	                        2. Withdraw
	                        3. Balance
	                        4. Statement
	                        5. Transfer
	                        6. Deductions
	                        7. Zakat
	                        8. Interest

	                        """);




	        Scanner scan = new Scanner(System.in);
	        inp = scan.nextByte();
	        if(inp==0) return;
	        Ops(inp,acc);

	        
	   }
		
	}
	
	void InterestRate() {
		
		SavingAccount acc = new SavingAccount("mkjn");
		System.out.println("Enter Percentage Interest!!\n");
		Scanner scan = new Scanner(System.in);
	    float dep = scan.nextFloat();
	    if(dep>=90 || dep<=0) System.out.println("This is not a valid percentage!!\n");
	    else	acc.InterestSetter(dep);
	}
    
    
}
