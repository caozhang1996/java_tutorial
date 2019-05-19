package bank1;
/**
 * bank1
 * 在这个练习里,创建一个简单版本的Account类.并在另一个文件中调用该java文件中的类
 * 1.创建私有对象属性:balance,这个属性保留当前余额
 * 2.创建构造器为balance赋值
 * 3.创建方法获取余额,并进行存款,提取等操作 
 * 例如输出如下结果:
 * Creating an account with a 1000.00 balance
 * Withdraw 200.00
 * Deposit 30.5
 * Withdraw 57.91
 * The account has a balance of 772.59
 */
public class Account {
	private double balance;

    public Account(double init_balance){
        balance = init_balance;
    }

    public double getBalance(){
        return balance;
    }

    public void Deposit(double atm){
        balance += atm;
    }

    public void Withdraw(double atm){
        if(balance >= atm){
            balance -= atm;
        }else{
            System.out.println("余额不足!");
        }
        
    }
}
