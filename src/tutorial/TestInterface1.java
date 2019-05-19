package tutorial;


/*
 * 定义一个接口用来实现两个对象的比较
 * interface CompareObject{
 * 		public int compareTo(Object o);  //返回值是0，代表相等；若为1，代表当前对象大，-1代表当前对象小
 * }
 * 1.定义一个Rectangle(矩形)类
 * 2.定义一个CompareRectangle类，继承Rectangle类并实现CompareObject接口，在CompareRectangle类中给出
 *   接口中方法compareTo的实现体，用来比较两个矩形面积大小。
 * 3.定义一个测试类TestInterface1，创建几个CompareRectangle对象，调用compareTo方法比较两个对象的面积大小。
 */
public class TestInterface1 {
	public static void main(String[] args) {
		CompareRectangle r1 = new CompareRectangle(2, 4);
		CompareRectangle r2 = new CompareRectangle(4, 2);
		CompareRectangle r3 = new CompareRectangle(3, 4);
		try {
			System.out.println(r1.compareTo(r2));
			System.out.println(r1.compareTo("AA"));
		}catch(RuntimeException e){
			System.out.println(e.getMessage());;
		}
	}
}

interface CompareObject{
	public abstract int compareTo(Object o);
}

class Rectangle {
	protected double width;
	protected double height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getArea() {
		return width * height;
	}
}

class CompareRectangle extends Rectangle implements CompareObject{
	public CompareRectangle(double width, double height){
		super(width, height);
	}
	
	public int compareTo(Object obj) {
		if(this == obj) {
			return 0;
		}else if(obj instanceof CompareRectangle) {
			CompareRectangle rectangle = (CompareRectangle)obj;
			if(this.getArea() == rectangle.getArea()) {
				return 0;
			}else if(this.getArea() > rectangle.getArea()) {
				return 1;
			}else {
				return -1;
			}
		}else {
			throw new RuntimeException("比较的不是一个CompareRectangle对象");      //throw抛出的是异常的对象
		}
	}
}