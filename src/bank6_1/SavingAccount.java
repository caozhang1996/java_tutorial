package bank6_1;
/*
 * 1.创建SavingAccount类，该类继承Account类
 * 2.该类必须包含一个类型为double类的interestRate属性
 * 3.该类必须包含带有两个参数(balance和interestRate)的公有构造器，这个构造器必须通过
 *   super(balance)将balance属性传递给父构造器
 * */
public class SavingAccount extends Account{        //储蓄账户
	private double interestRate;

	public SavingAccount(double balance, double interestRate) {
		super(balance);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
}
