package testbank;
import bank6_1.*;
/*
 * 在该类中测试bank6_1（instanceof的使用练习）
 * 添加以下用户，他们每个人都有储蓄账户和信用卡账户，并且进行存取钱操作
 * "Jane Smith"，"Tonny Stark"，"Peter Parker"，“James Harden"
 * 并输出每个人的账户
 * */
public class TestBank6_1 {
	public static void main(String[] args) {
		Bank bank = new Bank(4);
		bank.addCustomer("Jane", "Smith", 2);
		bank.getCustomer(0).setAccount(new CheckAccount(500.00, 500.00));
		bank.getCustomer(0).setAccount(new SavingAccount(1000.00, 0.05));
		
		bank.addCustomer("Tonny", "Stark", 2);
		bank.getCustomer(1).setAccount(new CheckAccount(700.00, 200.00));
		bank.getCustomer(1).setAccount(new SavingAccount(1200.00, 0.08));
		
		bank.addCustomer("Peter", "Parker", 2);
		bank.getCustomer(2).setAccount(new CheckAccount(800.00, 300.00));
		bank.getCustomer(2).setAccount(new SavingAccount(900.00, 0.06));
		
		bank.addCustomer("James", "Harden", 2);
		bank.getCustomer(3).setAccount(new CheckAccount(600.00, 400.00));
		bank.getCustomer(3).setAccount(new SavingAccount(1100.00, 0.05));
		
		//遍历输出
		System.out.println("\t\t\tCUSTOMERR REPORT");
		System.out.println("\t\t\t================");
		String accountType = "";
		for(int cust_idx = 0 ; cust_idx < bank.getNumberOfCustomers(); cust_idx++) {
			System.out.println("Customer name: " + bank.getCustomer(cust_idx).getFirstName() + " " + 
					bank.getCustomer(cust_idx).getLastName());
			for(int acc_idx = 0; acc_idx < bank.getCustomer(cust_idx).getNumberOfAccounts(); acc_idx++){
				if(bank.getCustomer(cust_idx).getAccount(acc_idx) instanceof CheckAccount) {//判断account的类型
					accountType = "CheckAccount: ";
					CheckAccount checkAccount = (CheckAccount)bank.getCustomer(cust_idx).getAccount(acc_idx);  //多态
					System.out.println(accountType + "balance: " + checkAccount.getBalance() + " overdraft: " + 
							checkAccount.getOverdraft());
				}
				if(bank.getCustomer(cust_idx).getAccount(acc_idx) instanceof SavingAccount) {
					accountType = "SavingAccount: ";
					SavingAccount savingAccount = (SavingAccount)bank.getCustomer(cust_idx).getAccount(acc_idx);
					System.out.println(accountType + "balance: " + savingAccount.getBalance() + " interestrate: " + 
							savingAccount.getInterestRate());
				}
			}
			System.out.println();
		}
	}
	
}
