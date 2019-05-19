package bank6;
/*
 * 练习继承，多态，方法的重写
 * 在这个练习里,创建一个简单版本的Account类.并在另一个文件中调用该java文件中的类
 * 1.创建私有对象属性:balance,这个属性保留当前余额
 * 2.创建构造器为balance赋值
 * 3.创建方法获取余额,并进行存款,提取等操作,方法返回一个flag表示取款，存款操作是否成功
 * */
public class Account {
	protected double balance;
	
	public Account(double balance) {
		this.balance = balance;
	}
	public double getBalance() {
		return balance;
	} 
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public boolean deposit(double atm) {
		balance += atm;
		return true;
	}
	
	public boolean withdraw(double atm) {
		if(balance >= atm) {
			balance -= atm;
			return true;
		}else {
			System.out.println("余额不足！");
			return false;
		}
		
	}
}
