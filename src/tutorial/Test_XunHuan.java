package tutorial;
/**
 * Test_XunHuan
 */
import java.util.Scanner;

public class Test_XunHuan {

    public static void main(String[] args) {
        test_ForFor();
    }


    /**
     * for循环结构
     * a、初始化条件
     * b、循环条件
     * c、迭代条件
     * d、循环体
     * 1、格式：
     * for(a;b;c){
     *     d
     * }
     * 2、执行过程: a->b->d->c->b->d->c......->d->c->b
     *    即直至循环条件不满足，退出当前循环。
     */
    public static void test_For() {
        //输出四个HelloWorld！
        for (int i = 0; i < 4; i++) {
            System.out.println("HelloWorld!");
        }
        System.out.println();

        //输出100以内所有的偶数以及所有偶数的和、及偶数的个数
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
                count++ ;
            }
        }
        System.out.println("100以内偶数的个数为: " + count);
        System.out.println("100以内所有偶数的和为: " + sum);

        //第三个例子，更好理解for循环执行过程
        int j = 1;
        for(System.out.println('a'); j < 4; System.out.println('b'), j++){
            //执行过程为: acbcbcb
            System.out.println('c');
        }

        /*
         * 编写程序: 从1循环到150并在每行打印一个值，另外在每个3的倍数行上打印出“foo”，在每个5的倍数行上打印出“biz”，
         * 在每个7的倍数行上打印出“baz”
         */
    }

    /**
     * while循环
     * a、初始化条件
     * b、循环条件
     * c、迭代条件
     * d、循环体
     * 1、格式：
     * a
     * while(b){
     *    d
     *    c
     * }
     * 2、for循环与while循环可以相互转换。 
     */
    public static void test_While() {
        //输出100以内所有的偶数以及所有偶数的和、及偶数的个数
        int i = 1;
        int sum = 0;
        int count = 0;
        while(i <= 100){
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
                count++;
            }
            i++;
        }
        System.out.println("100以内偶数的个数为: " + count);
        System.out.println("100以内所有偶数的和为: " + sum);
    }

    /**
     * do while循环
     * a、初始化条件
     * b、循环条件
     * c、迭代条件
     * d、循环体
     * 1、格式:
     * a
     * do{
     *   d
     *   c
     *  }while(b)
     */
    public static void test_DoWhile() {
        int i = 1;
        int sum = 0;
        int count = 0;
        do{
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
                count++;
            }
            i++;
        }while(i <= 100);
        System.out.println("100以内偶数的个数为: " + count);
        System.out.println("100以内所有偶数的和为: " + sum);


        // do while 和while的区别
        int j = 10;
        do{
            System.out.println("j的值为: " + j);      //先执行再判断while里面的循环条件
            j++;
        }while(j < 10);    //本身j=10不满足这个条件，但也执行了循环体一次，同样的代码改成while就不会

        while(j < 10){
            System.out.println("j的值为: " + j);     
            j++;
        }
    }

    //问题一、从键盘读入个数为10个的整数，并判断读入的正数和负数的个数.
    public static void test_10Number() {
        Scanner str = new Scanner(System.in);  
        int a = 0;      //记录整数个数
        int b = 0;      //记录负数个数
        for(int i = 0; i < 10; i++){
            System.out.println("请输入第" + (i + 1) + "个数");
            int number = str.nextInt();
            if(number > 0){
                a++;
            }else if(number < 0){
                b++;
            }
        }
        System.out.println("正数个数为: " + a);
        System.out.println("负数个数为: " + b);        
        
    }


    //问题二、从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入为0时结束程序。
    public static void test_Numbers() {
        Scanner str = new Scanner(System.in);
        int a = 0;      //记录整数个数
        int b = 0;      //记录负数个数
        for(;;){        //死循环,相当于while
            System.out.println("请输入一个整数");
            int number = str.nextInt();
            if(number > 0){
                a++;
            }else if(number < 0){
                b++;
            }else{
                break;
            }
        }
        System.out.println("正数个数为: " + a);
        System.out.println("负数个数为: " + b);
    }

    /*嵌套循环,循环中还可以声明循环,相当于内层循环的整体充当外层循环的循环体
    *for(;;){
        for(;;){

        }
    }
    或者
    while(){
        for(;;){

        }
    }
    */
    
    public static void test_ForFor(){
        /*题目:输出一下形状
        *
        **
        ***
        ****
        *****
        ****
        ***
        **
        *
        */
        for(int i = 1; i <= 5; i++){      //上半部分
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
         }                              

        for(int i = 1; i <= 4; i++){     //下半部分
            for(int j = 4; j >= i; j--){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        /*题目:输出一下形状
            *
           * *
          * * *
         * * * *
        * * * * * 
         * * * *
          * * *
           * *
            *
        */
        for(int i = 1; i <= 5; i++){      //上半部分
            for(int j = 5; j > i; j--){
                System.out.print(" ");
            }
            for(int k = 1; k <= i; k++){
                System.out.print("* ");
            }
            System.out.println();
        }

        for(int i = 1; i <= 4; i++){     //下半部分
            for(int j = 1; j <= i; j++){
                System.out.print(" ");
            }
            for(int k = 4; k >= i; k--){
                System.out.print("* ");
            }
            System.out.println();
        }

        /**
         * 打印九九乘法表
         */
        for(int i =1; i <= 9; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(i + "*" + j + "=" + i*j + "\t");
            }
            System.out.println();
        }

        /**
         * 输出100以内的所有质数(素数)
         * 质数的定义:除了1和它本身,不再有其他的因数(除了1和它自身外,不能被其他的自然数整数)
         */
        boolean flag = false;
        long start = System.currentTimeMillis();   //获取系统当前的毫秒数
        for(int i = 2; i <= 100000; i++){
            for(int j = 2; j < Math.sqrt(i); j++){
                if(i % j == 0){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                System.out.println(i);
            }
            flag = false;
        }
        long end = System.currentTimeMillis();
        System.out.println("所花时间: " + (end - start)); //不加break: 17909, 加break: 1421, 加根号:71
    }
}