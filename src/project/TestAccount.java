package project;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAccount {

	Account s,c,s2;
	Admin admin;
	
	@Before
	public void Starter() throws Throwable {
		s = new SavingAccount("S_abc");	
		s2 = new SavingAccount("S_abcd");			
		c = new CheckingAccount("C_cba");

		admin = new Admin();

		s2.makeDeposit(5000);
	}
	
	@Test
	public void testDepositWithdrawal() {
		
		Assert.assertEquals("Equal", c.makeDeposit(3000.0),c.makeWithdrawal(0.0),0); // Deposited and Withdrawal success
		c.makeWithdrawal(3000.0);
	}
	

	@Test
	public void testDepositWithdrawals() {
		
		Assert.assertNotEquals("Not Equal",s.makeWithdrawal(54.0),s.makeDeposit(1000.0),0); // Deposited and Withdrawal fail
	}
	
	@Test
	public void testTransferBalance() {
		
		Assert.assertEquals("Equal",s.transferAmount(c,500.0), c.checkBalance(),0); // Transferred
	}
	
	@Test
	public void testTransferBalances() {
		
		Assert.assertEquals("Not Equal",s.transferAmount(c,1000.0), 0.0,0); //transfer fail
		
	}
	
	@Test
	public void Zakat() {
		Assert.assertTrue(s.calculateZakat()<1.0);		//Zakat
	}
	
	@Test
	public void Zakats() {
		s.makeDeposit(300000);
		Assert.assertTrue(s.calculateZakat()>1.0);				
	}

	@Test
	public void Interests() {	//Interest rate

		Assert.assertTrue(s2.calculateInterest()<1);
	}
	
	@Test
	public void Interest() {
		SavingAccount savi = new SavingAccount("S_hhh");
		savi.InterestSetter(10);
		Assert.assertTrue(s2.calculateInterest()>1);
	}
	
}
