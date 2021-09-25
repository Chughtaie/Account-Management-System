package project;


public class CheckingAccount extends Account {

    double haram = 5_000.0;

    int transactions;


    CheckingAccount(){
        type=false;
        account_no = "C_"+Integer.toString(customer.ID) + "_" +customer.name;
        transactions=0;
    }
    CheckingAccount(String abc){
        super(abc);
        account_no=abc;
        type=false;
        transactions=0;
    }

    double makeWithdrawal(double amount) {
        if(balance+haram>=amount) {
            balance -= amount;
            System.out.println("Money Withdrawed!");
        }else System.out.println("You don't have much balance!");

        checkBalance();
        return balance;
    }
    

}
