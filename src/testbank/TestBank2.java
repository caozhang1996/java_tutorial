package testbank;

import bank2.Account;
import bank2.Customer;

public class TestBank2 {
	public static void main(String[] args) {
        Customer customer;
        Account account;
        
        customer = new Customer("Jane", "Smith");
        System.out.println("Creating the customer Jane Smith");
        
        account = new Account(500.00);

        customer.setAccount(account);
        System.out.println("Creating her account with a 500.00 balabce");
        
        customer.getAccount().Withdraw(150.00);
        System.out.println("Withdraw 150.00");
        
        customer.getAccount().Deposit(22.50);
        System.out.println("Deposit 22.50");
        
        customer.getAccount().Withdraw(47.62);
        System.out.println("Withdraw 47.62");

        //Print out the final account balance
        System.out.println("Customer " + customer.getFirstName() + " " + 
                            customer.getLastName() + " has a balance of " + customer.getAccount().getBalance());
        }
}
