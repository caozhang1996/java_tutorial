package tutorial;
import java.util.Scanner;


/**
 * TestYunSuanFu: 测试运算符（逻辑运算符(&, &&, |, ||, ^, !)，三元运算符, 位运算符）
 */
public class TestYunSuanFu {

    public static void main(String[] args){
        //logic();
        sanYuan();
    }

    public static void logic(){
        boolean b1 = true;
        boolean b2 = false;

        System.out.println(b1 & b2);
        System.out.println(b1 && b2);
        System.out.println(b1 | b2);
        System.out.println(b1 || b2);
        System.out.println(b1 ^ b2);
        System.out.println(b1 & !b2);

        //&与&&（短路与）的区别：&:不管左端是true还是false，右端都会运算
        //                   &&:当左端是false时，右端不会运算
        int i1 = 10;
        if(b2 & (i1++) > 0){
            System.out.println("今天天气很晴朗！");
        }else{
            System.out.println("没有雾霾！");
        }
        System.out.println("i1的值: " + i1);

        int i2 = 10;
        if(b2 && (i2++) > 0){
            System.out.println("今天天气很晴朗！");
        }else{
            System.out.println("没有雾霾！");
        }
        System.out.println("i2的值: " + i2);

        //|与||（短路或）的区别：|:不管左端是true还是false，右端都会运算
        //                   ||:当左端是true时，右端不会运算
        int i3 = 10;
        if(b1 | (i3++) > 0){
            System.out.println("今天天气很晴朗！");
        }else{
            System.out.println("没有雾霾！");
        }
        System.out.println("i3的值: " + i3);

        int i4 =10;
        if(b1 || (i4++) > 0){
            System.out.println("今天天气很晴朗！");
        }else{
            System.out.println("没有雾霾！");
        }
        System.out.println("i4的值: " + i4);

    }

    public static void sanYuan(){
        /**
         * 三元运算符：(条件表达式)? 表达式1 : 表达式2
         * 要求：表达式1与表达式2为同种数据类型。
         *      既然是运算符，就一定会有运算的结果，结果的数据类型与表达式1,2的类型一致。
         * 三元运算符在一定程度上可以与if-else呼唤（三元运算符一定可以转换成if-else,反之不成立。）
         */
        int i = 10;
        int j = 20;
        int max = (i > j)? i : j;  //max值为i，j中的较大值
        System.out.println("max的值为: " + max);

        String str = (i > j)? "i较大" : (i == j)? "相等" : "j较大";
        System.out.println("两者的比较结果: " + str);

        //练习: 使用三元素法找出三个数中的最大值
        int a = -2, b = 90, c = 19;
        int max1 = (a > b)? a : b;
        int max2 = (max1 > c)? max1 : c;
        System.out.println("三数中的最大值为: " + max2);


        //问题：将一个十进制数转换为十六进制数,例如将65转换为0x41   
        Scanner s = new Scanner(System.in);
        System.out.println("请输入一个十进制数");
        int myInt = s.nextInt();

        int m = myInt & 15;     //获取myInt的低4位值
        String x = (m <= 9)? m + "" : (char)(m - 10 + 'a') + "";  //得到后4位转换的16进制数

        int n = (myInt >> 4) & 15;         //移位:获取myInt的高4位值
        String y = (n <= 9)? n + "" : (char)(n - 10 + 'a') + ""; //得到前4位转换的16进制数
        System.out.println("0x" + y + x);

    }

    //数字在计算机中的存储
    /**
     * 1.一些基本概念:
     * 原码:在数值前面增加了一位符号位（即最高位为符号位）：正数该位为0，负数该位为1，其余位表示数值的大小。
     * 反码:正数的反码就是原码，负数的反码是符号位不变，其他位取反
     * 补码:正数的补码就是原码，负数的补码是反码+1
     * 2.在计算机中正数以原码方式存储,负数以补码方式存储
     */
    
}