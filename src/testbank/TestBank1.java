package testbank;

import bank1.Account;

public class TestBank1 {

	public static void main(String[] args) {
		Account account = new Account(1000.00);
        System.out.println("Creating an account with a 1000.00 balance");

        account.Withdraw(200.00);
        System.out.println("withdraw 200.00");

        account.Deposit(30.5);
        System.out.println("Deposit 30.5");

        account.Withdraw(57.91);
        System.out.println("Withdraw 57.91");
        System.out.println("The account has a balance of " + account.getBalance());

	}

}
