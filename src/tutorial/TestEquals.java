package tutorial;
/*
 * 重写equals方法，来判断两个对象中的内容是否相等
 * */
public class TestEquals {
	public static void main(String[] args) {
		Triangle tri1 = new Triangle(2, 4);
		Triangle tri2 = new Triangle(2, 4);
		Triangle tri3 = new Triangle(3, 4);
		System.out.println(tri1.equals(tri2));
		System.out.println(tri1.equals(tri3));
	}
}

class Triangle {
	private double base;
	private double height; 
	
	public Triangle(double base, double height) {
		super();
		this.base = base;
		this.height = height;
	}
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	public boolean equals(Object obj) {    //对Object对象中的equals方法进行重写
		if(this == obj) {
			return true;
		}else if(obj instanceof Triangle) {
			Triangle triangle = (Triangle)obj; 
			return this.getBase() == triangle.getBase() && this.getHeight() == triangle.getHeight();
		}else {
			return false;
		}
	}       
}
