package bank5;
/*
 * 继承性与super的使用练习
 * 1.写一个名为Account的类的模拟账户，该类的属性账号id，余额balance，年利率annualInterestRate
 *  包含的方法：访问器方法(getter和setter方法)，返回月利率的方法getMonthlyInterest(),取款方法withdraw(),
 *  存款方法deposit()
 *  
 * */
public class Account {
	protected int id;
	protected double balance;
	protected double annualInterestRate;
	
	public Account(int id, double balance, double annualInterestRate) {
		super();
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}  
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public double getMonthlyInterest() {
		return annualInterestRate / 12;
	}
	public boolean withdraw(double atm) {
		if(balance >= atm) {
			balance -= atm;
			return true;
		}else {
			System.out.println("账户余额不足！");
			return false;
			}		
	}
	public boolean deposit(double atm) {
		balance += atm;
		return true;
	}
}
