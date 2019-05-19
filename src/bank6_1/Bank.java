package bank6_1;

/*
 * 对于银行来说，可添加Bank类，Bank对象跟踪自身与其客户建的关系，用Customer
 * 对象的数组实现这个集合化的关系，还要保持一个整数属性来跟踪银行当前有多少客户。
 * 1.创建Bank类
 * 2.为Bank类增加两个属性：customers（Customer对象的数组）和numberOfCustomers(
 * 整数，是customers数组的索引）
 * 3.添加公有构造器，以合适的最大尺寸（至少大于5）初始化customers数组
 * 4.添加addCustomer方法，该方法必须按照参数（姓，名）构造一个新的customer
 * 5.添加getNumberOfCustomers方法，返回numberOfCustomers值
 * 6.添加getCustomer方法，返回索引为index的customer
 * */
public class Bank {
	private Customer[] customers;
	private int numberOfCustomers;
	
	public Bank(int num) {
		customers = new Customer[num];  //以num初始化customers数组
	}
	
	public void addCustomer(String firstName, String lastName, int account_num) {
		customers[numberOfCustomers] = new Customer(firstName, lastName, account_num);
		numberOfCustomers++;
	}

	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	
	public Customer getCustomer(int index) {
		return customers[index];
	}
}
