package bank6;
/*
 * 在这个练习中,创建Customer类,并在另一个文件中调用该java文件中的类 
 * 1.声明三个私有对象属性:firstName,lastName和account
 * 2.声明一个公有构造器,构造器初始化firstName,lastName
 * 3.声明公有方法来访问对象对象属性,返回相应的属性
 * 4.声明方法来对account属性赋值
 * 5.声明方法来获取account属性
 * */
public class Customer {
	private String firstName;
	private String lastName;
	private Account account;
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
