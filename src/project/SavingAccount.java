package project;



    public class SavingAccount extends Account{

        static float interest_rate=0;
        
        SavingAccount(){
            type = true;
            account_no = "S_"+Integer.toString(customer.ID) + "_" +customer.name;
        }
        SavingAccount(String abc){
            super(abc);
            account_no = abc;
            type=true;
        }
        
        void InterestSetter(float val) {
        	interest_rate =val;
        }

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
            }else {
            	System.out.println("You dont have much balance to withdraw!");
            	return 0.0;
            }
            
            checkBalance();
            return balance;
        }
        
        double calculateInterest(){
            double rate = balance*(interest_rate/100);
            System.out.println("Current Interest @"+ interest_rate + "% = " + rate);
            return rate;
        }

    }


