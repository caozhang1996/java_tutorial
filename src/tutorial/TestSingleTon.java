package tutorial;
/*
 * 单例模式: 对于定义的一个类，在整个应用程序执行期间只有唯一的一个实例对象。
 */
public class TestSingleTon {
	public static void main(String[] args) {
		HuNanUniversity instance1 = HuNanUniversity.getInstance();
		HuNanUniversity instance2 = HuNanUniversity.getInstance();
		System.out.println(instance1);
		System.out.println(instance2);
		System.out.println(instance1 == instance2);  //两者的引用相同说明指向同一地址，即同一对象
		instance1.showSchoolRules();
		instance2.showSchoolRules();

	}
}

class HuNanUniversity{
	private static final String NAME = "湖南大学";
	private static final String DESC = "千年学府，百年名校";
	
	//1.私有化构造器，使得在类的外部不能够调用此构造器
	private HuNanUniversity() {         //单例模式的构造器必须是私有的
		
	}

	//2.在类的内部创建一个类的实例
	private static HuNanUniversity hnu = new HuNanUniversity();
    
	//3.私有化此对象，通过公共的方法来调用
	//4.此公共的方法，只能通过类来调用，所以设置为static的，同时类的实例也必须为static声明的
	public static HuNanUniversity getInstance() {
		return hnu;
	}
	
	public static String getName() {
		return NAME;
	}
	
	public static String getDesc() {
		return DESC;
	}
	
	public void showSchoolRules() {
		System.out.println("实事求是，敢为人先"); 
	}
	
}
//单例模式的一般模型:
//饿汉式
class SingleTon{
	
	//1.私有化构造器
	private SingleTon() {
		
	}
	
	//2.在类的内部实例化一个SingleTon对象
	private static SingleTon instance = new SingleTon();
	
	//3.私有化此对象，通过公共的方法来调用
	//4.此公共的方法，只能通过类来调用，所以设置为static的，同时类的实例也必须为static声明的
	public static SingleTon getInstance() {
		return instance; 
	}
} 

//懒汉式: 可能存在线程安全问题（在多线程章节中学习）
class SingleTon_{
	private SingleTon_(){
		
	}
	
	private static SingleTon_ instance;
	
	public static SingleTon_ getInstance() {
		if(instance == null) { 
			instance = new SingleTon_();
		}
		return instance;
	}
}