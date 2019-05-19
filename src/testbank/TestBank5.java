package testbank;
import bank5.*;
/*
 * 写一个用户程序测试CheckAccount类，在用户程序中，
 * 创建一个账号为1122、余额为20000、年利率4.5%，可透支限额为5000元的CheckAccount对象。
 * 使用withdraw方法取款5000元，并打印账户余额和可透支额。
 * 再使用withdraw方法提款18000元，并打印账户余额和可透支额。
 * 再使用withdraw方法提款3000元，并打印账户余额和可透支额。
 * */
public class TestBank5 {
	public static void main(String[] args) {
		CheckAccount cAccount = new CheckAccount(1122, 20000.00, 0.0045, 5000);
		System.out.println("当前余额: " + cAccount.getBalance() + " 当前可透支额: " + cAccount.getOverdraft());
		System.out.println("取款5000: " + cAccount.withdraw(5000));
		System.out.println("账户余额: " + cAccount.getBalance() + " 可透支额: " + cAccount.getOverdraft());
		System.out.println("取款18000: " + cAccount.withdraw(18000));
		System.out.println("账户余额: " + cAccount.getBalance() + " 可透支额: " + cAccount.getOverdraft());
		System.out.println("取款3000: " + cAccount.withdraw(3000));
		System.out.println("账户余额: " + cAccount.getBalance() + " 可透支额: " + cAccount.getOverdraft());
		System.out.println("账户月利率为: " + cAccount.getMonthlyInterest());
	}
}
