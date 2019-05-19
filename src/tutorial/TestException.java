package tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * 异常处理有两种处理方式:①try-catch-finally②throws
 * 处理方式一:
 * try{
 * 
 * }catch{
 * 
 * }finally{
 * 
 * }
 * 处理方式二:在方法的声明处，显式地抛出该异常对象的类型
 * 格式:public void method() throws Exception{}
 * 当在此方法内部出现异常的时候，会抛出一个异常类的对象，抛给方法的调用者。
 * 异常的对象可以逐层向上抛，直至main中，当然在向上抛的过程中，可以再通过try-catch-finally进行处理
 * 
 * java的异常处理，抓抛模型
 * 1.抓:异常的的处理有两种方式(①try-catch-finally②throws + 异常的类型)
 * 2.抛:一旦执行过程中，出现异常，会抛出一个异常类的对象(自动抛出和手动抛出(异常类的对象))
 *   --->手动抛出的异常类既可以是现成的异常类，也可以是自己创建的异常类
 */
/*
 * 例子:读取一个文件
 */
public class TestException {
	public static void main(String[] args) {   //两种异常的不同处理方式
		try {
			method();
		}catch(FileNotFoundException e){             
			System.out.println(e.getMessage());   //打印异常信息
		}catch(IOException e){
			e.getStackTrace();          //获得栈信息
		}
	}
	
	public static void method() throws FileNotFoundException,IOException {
		FileInputStream fileInputStream = new FileInputStream(new File("/home/caozhang/java_projects/java_tutorial/src/tutorial/hello.txt"));
		int b;
		while((b = fileInputStream.read())!= -1) {    //read时可能出现IO异常
			System.out.println((char)b);
		}
		fileInputStream.close();
	}
}
