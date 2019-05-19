package testbank;

import bank3.Account;
import bank3.Customer;

public class TestBank3 {
	public static void main(String[] args) {
		Customer customer;
		Account account;
		
		customer = new Customer("Jane", "Smith");
		System.out.println("Creating the customer Jane Smith");
		
		account = new Account(500.00);
		customer.setAccount(account);
		System.out.println("Creating her account with a 500.00 balabce");
		System.out.println("Withdraw 150.00 " + customer.getAccount().withdraw(150.00));
		System.out.println("Deposit 22.50 " + customer.getAccount().deposit(22.50));
		System.out.println("Withdraw 47.62 " + customer.getAccount().withdraw(47.62));
		
		//Print out the final account balance 
        System.out.println("Customer [" + customer.getFirstName() + " " + 
                            customer.getLastName() + "] has a balance of " + customer.getAccount().getBalance());
	}
	
}
