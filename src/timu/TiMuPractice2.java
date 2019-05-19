package timu;
import java.util.Scanner;

/**
 * TiMuPractice2
 * 匿名类对象:创建的类的对象是匿名的.
 *       1):当我们只需要一次条用类的对象时,我们就可以考虑使用匿名的方式创建类的对象.
 *       2):特点:创建的匿名类的对象只能调用一次
 */
public class TiMuPractice2 {
    public static void main(String[] args) {
//        new Methods().getSum(1, 2, 3, 4);       //匿名类的使用
        findHighScore();
    }

    public static void test_Circle() {
        Circle c1 = new Circle();
        int time = 7;
        PassObject object = new PassObject();
        object.printAreas(c1, time);
    }

     /*
      * 从键盘输入学生个数
      * 从键盘读入学生成绩,找出最高分,并输出学生成绩等级.
      * 成绩>=最高分-10  等级为A
      * 成绩>=最高分-20  等级为B
      * 成绩>=最高分-30  等级为C
      * 其余            等级为D
      * 提示:先读入学生人数,根据人数创建int数组,存放学生成绩
      */
    public static void findHighScore() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("请输入学生个数:");
    	int count = scanner.nextInt();
    	
    	int scores[] = new int[count];
    	int maxScore = 0;
    	System.out.println("请输入学生分数");
    	for(int i = 0; i < scores.length; i++) {
    		int score = scanner.nextInt();
    		if(maxScore < score)
    			maxScore = score;
    		scores[i] = score;
    		}
    	
    	System.out.println("学生成绩最高分为: " + maxScore);
    	char level;
    	for(int i = 0; i < scores.length; i++) {
    		if(scores[i] >= maxScore - 10) {
    			level = 'A';
    		}else if(scores[i] >= maxScore - 20) {
    			level = 'B';
    		}else if(scores[i] >= maxScore - 30) {
    			level = 'C';
    		}else {
    			level = 'D';
    		}
    		System.out.println("student " + i +" score is " + scores[i] + ". grade is " + level);
    	}
    }
}

/**
 * 题目一:将对象作为形参传递给方法
 * 题目要求:
 * (1)定义一个Circle类,包含一个double型的radius属性代表圆的半径,一个findArea()方法返回
 * 圆的面积.
 * (2)定义一个类PassObject,在类中定义一个方法printAreas(),该方法的定义如下:
 *                 public void printAreas(Circle c, int time)
 * 在printAreas方法中打印输出1到time之间的每个整数半径值,以及对应的面积,例如:time为5,
 * 则输出半径1, 2, 3, 4, 5,以及对应的面积.
 * (3)在main方法中调用printAreas方法,调用完毕后输出当前半径值.
 */

 class Circle{
     double radius; 

     public void set_Redius(double r) {
         radius = r;
     }

     public double findAreas()
     {
        return Math.PI * radius * radius;
     }
 }

 class PassObject{
     public void printAreas(Circle c, int time){
         //第一种方法
         int temp = 0;
         for(int i = 1; i <= time; i++, temp = i){    //i先自加,然后将i的值赋给temp
             c.set_Redius(i);
             double area = c.findAreas();
             System.out.println(i + "\t" + area);
         }
         System.out.println(" " + "now the radius is: "+ temp);
         System.out.println();

         //第二种方法
         int i = 1;
         while(i <= time){
             c.set_Redius(i);
             double area = c.findAreas();
             System.out.println(i + "\t" + area);
             i++;
         }
         System.out.println(" " + "now the radius is: "+ i);
         System.out.println();
     }
 }

 /**
  * 可变个数的形参的方法:
    1.格式: 数据类型 ... 形参名
    2.可变个数的形参的方法与同名的方法之间构成重载
    3.可变个数的形参在调用时,个数从0开始,到无穷多个都可以
    4.使用可变个数的形参的方法与方法的形参使用数组是一致的
    5.若方法中存在可变个数的形参,那么一定要申明在方法形参的最后(例如: public void name(int i , String ... args))
    6.在一个方法中,最多声明一个可变个数的形参
*/
class Methods{
    public void getSum(int i, int j) {
        System.out.println(i + j);
    }

    // public void getSum(int[] ints){
    //     int sum = 0;
    //     for(int i = 0; i < ints.length; i++){
    //         sum += ints[i];
    //     }
    //     System.out.println(sum);
    // }

    public void getSum(int ... ints){      //可变个数的形参的方法与方法的形参使用数组是一样的
        int sum = 0;
        for(int i = 0; i < ints.length; i++){
            sum += ints[i];
        }
        System.out.println(sum);
    }
}
