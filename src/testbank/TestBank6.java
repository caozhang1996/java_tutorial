package testbank;
import bank6.*;
/*
 * 在该类中测试bank6
 * 添加五个用户，并为他们创建储蓄账户或者信用卡账户，并且进行存取钱操作
 * "Jane Smith"，"Tonny Stark"，"Peter Parker"，“James Harden"，”Paper Stark"
 * */
public class TestBank6 {
	public static void main(String[] args) {
		Bank bank = new Bank(5);      //实例化Bank对象，里面有五个customers
		
		System.out.println("Creating this customer Jane Smith");
		bank.addCustomer("Jane", "Smith");
		
		System.out.println("Creating her Saving Account with 500.00 balance and 3% interestRate");
		bank.getCustomer(0).setAccount(new SavingAccount(500.00, 0.03));       //多态
		
		System.out.println("Creating this customer Tonny Stark");
		bank.addCustomer("Tonny", "Stark");
		
		System.out.println("Creating his Checking Account with 500.00 balance and 500.00 in overdraft");
		bank.getCustomer(1).setAccount(new CheckAccount(500.00, 500.00));
		
		System.out.println("Creating this customer Peter Parker");
		bank.addCustomer("Peter", "Parker");
		 
		System.out.println("Creating his Checking Account with 500.00 and no overdraft");
		bank.getCustomer(2).setAccount(new CheckAccount(500.00));
		
		System.out.println("Creating this customer James Harden");
		bank.addCustomer("James", "Harden");
		
		System.out.println("Creating his Saving Account with 1000.00 and 5% interestRate");
		bank.getCustomer(3).setAccount(new SavingAccount(1000.00, 0.05));
		
		System.out.println("Creating this customer Paper Stark");
		bank.addCustomer("Paper", "Stark");
		 
		System.out.println("Paper shares her Check account with her husband Tonny");
		bank.getCustomer(4).setAccount(bank.getCustomer(1).getAccount());
		System.out.println();
		
		//对每个账户进行存取款操作！
		System.out.println("Retrieving the customer Jane Smith with her saving account");
		System.out.println("Withdraw 150.00: " + bank.getCustomer(0).getAccount().withdraw(150));
		System.out.println("Deposit 22.50: " + bank.getCustomer(0).getAccount().deposit(22.50));
		System.out.println("withdraw 47.62: " + bank.getCustomer(0).getAccount().withdraw(47.62));
		System.out.println("withdraw 400.00: " + bank.getCustomer(0).getAccount().withdraw(400.00));
		System.out.println("Customer [" + bank.getCustomer(0).getFirstName() + " " + bank.getCustomer(0).getLastName() 
				+ "] has a balance of " + bank.getCustomer(0).getAccount().getBalance());
		System.out.println();
		
		System.out.println("Retrieving the customer Tonny Stark with his check account");
		CheckAccount account;
		account = (CheckAccount)bank.getCustomer(1).getAccount();    //多态,将父类强制转化为子类
		System.out.println("Withdraw 150.00: " + bank.getCustomer(1).getAccount().withdraw(150));
		System.out.println("Deposit 22.50: " + bank.getCustomer(1).getAccount().deposit(22.50));
		System.out.println("withdraw 47.62: " + bank.getCustomer(1).getAccount().withdraw(47.62));
		System.out.println("withdraw 400.00: " + bank.getCustomer(1).getAccount().withdraw(400.00));
		System.out.println("Customer [" + bank.getCustomer(1).getFirstName() + " " + bank.getCustomer(1).getLastName() 
				+ "] has a balance of " + account.getBalance() + " and " + account.getOverdraft() + " in overdraft");
		System.out.println();
		
		System.out.println("Retrieving the customer Peter Parker with his check account");
		account = (CheckAccount)bank.getCustomer(2).getAccount();
		System.out.println("Withdraw 150.00: " + bank.getCustomer(2).getAccount().withdraw(150));
		System.out.println("Deposit 22.50: " + bank.getCustomer(2).getAccount().deposit(22.50));
		System.out.println("withdraw 47.62: " + bank.getCustomer(2).getAccount().withdraw(47.62));
		System.out.println("withdraw 400.00: " + bank.getCustomer(2).getAccount().withdraw(400.00));
		System.out.println("Customer [" + bank.getCustomer(2).getFirstName() + " " + bank.getCustomer(2).getLastName() 
				+ "] has a balance of " + account.getBalance() + " and " + account.getOverdraft() +  " in overdraft");
		System.out.println();
		
		System.out.println("Retrieving the customer James Harden with his saving account");
		System.out.println("Withdraw 150.00: " + bank.getCustomer(3).getAccount().withdraw(150));
		System.out.println("Deposit 22.50: " + bank.getCustomer(3).getAccount().deposit(22.50));
		System.out.println("withdraw 47.62: " + bank.getCustomer(3).getAccount().withdraw(47.62));
		System.out.println("withdraw 400.00: " + bank.getCustomer(3).getAccount().withdraw(400.00));
		System.out.println("Customer [" + bank.getCustomer(3).getFirstName() + " " + bank.getCustomer(3).getLastName() 
				+ "] has a balance of " + bank.getCustomer(3).getAccount().getBalance());
		System.out.println();
		
		System.out.println("Retrieving the customer Paper Stark with his check account");
		account = (CheckAccount)bank.getCustomer(4).getAccount();
		System.out.println("Withdraw 150.00: " + bank.getCustomer(4).getAccount().withdraw(150));
		System.out.println("Deposit 22.50: " + bank.getCustomer(4).getAccount().deposit(22.50));
		System.out.println("withdraw 47.62: " + bank.getCustomer(4).getAccount().withdraw(47.62));
		System.out.println("withdraw 400.00: " + bank.getCustomer(4).getAccount().withdraw(400.00));
		System.out.println("Customer [" + bank.getCustomer(4).getFirstName() + " " + bank.getCustomer(4).getLastName() 
				+ "] has a balance of " + account.getBalance() + " and " + account.getOverdraft() + " in overdraft");
		System.out.println();
			
	}
	
}
