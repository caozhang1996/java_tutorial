package bank6_1;
/*
 * 1.创建CheckAccount类，该类继承Account类
 * 2.该类必须包含一个类型为double类的overdraft属性
 * 3.该类必须包含一个带有一个参数(balance)的公有构造器，这个构造器必须通过super(balance)将balance属性传递给父构造器
 * 4.该类必须包含一个带有两个参数(balance和overdraft)的公有构造器，这个构造器必须通过
 *   super(balance)将balance属性传递给父构造器，并将overdraft赋给this.overdraft
 * 5.CheckAccount类必须覆盖withdraw方法，该方法存在透支保护，当取款额atm<=balance时，正常运行
 *   当atm>balance时，尝试用overdraft来弥补差值(atm - balance),当overdraft<(atm - balance)时，交易失败
 * */
public class CheckAccount extends Account{
	private double overdraft;
	
	public CheckAccount(double balance) {
		super(balance);
	}
	
	public CheckAccount(double balance, double overdraft) {
		super(balance);
		this.overdraft = overdraft;
	}
	
	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}

	public boolean withdraw(double atm) {
		if(balance >= atm) {
			balance -= atm;
			return true;
		}else {
			if(overdraft >= (atm - balance)) {
				overdraft -= (atm - balance);
				balance = 0;
				return true;
			}else {
				System.out.println("透支额度不足！ 交易失败！");
				return false;
			}
		}
	}
}
