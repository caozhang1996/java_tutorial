package bank2;
/**
 * bank2
 * 在这个练习中,创建Customer类,并在另一个文件中调用该java文件中的类 
 * 1.声明三个私有对象属性:firstName,lastName和account
 * 2.声明一个公有构造器,构造器初始化firstName,lastName
 * 3.声明公有方法来访问对象对象属性,返回相应的属性
 * 4.声明方法来对account属性赋值
 * 5.声明方法来获取account属性
 * 
 */
public class Customer {
	
	private String firstName;
    private String lastName;
    private Account account;

    public Customer(String f, String l){
        firstName = f;
        lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAccount(Account acc){
        account = acc;
    }

    public Account getAccount(){
        return account;
    }
}
