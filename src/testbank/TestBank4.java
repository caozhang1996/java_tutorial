package testbank;

import bank4.*;

public class TestBank4 {
	public static void main(String[] args) {
		Bank bank = new Bank();

		//Add customer 
		bank.addCustomer("Jane", "Simms");
		//Add customer 
		bank.addCustomer("Tonny", "Stark");
		//Add customer 
		bank.addCustomer("Peter", "Parker");
		//Add customer
		bank.addCustomer("James", "Harden");
		//Add customer
		bank.addCustomer("Scott", "Lang");
		
		for(int i = 0; i < bank.getNumberOfCustomers(); i++) {
			System.out.println("Customer [" + (i + 1) + "] is " + bank.getCustomer(i).getFirstName() + " " +  
					bank.getCustomer(i).getLastName());
		}
	}
}
