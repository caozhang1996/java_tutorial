package bank2;

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
