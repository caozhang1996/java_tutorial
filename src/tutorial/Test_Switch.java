package tutorial;
/**
 * Test_Switch
 * 1、根据变量的值，选择相应的case去判断，一旦满足case条件，就执行case的相应语句。如果没有break或者已经
 * 到结尾的话，会继续执行其下的case语句。
 * 2、default是可选的，而且位置是灵活的。
 * 3、变量可以是哪些类型？char，byte，short，int，枚举，String
 * 4、case 条件：其中条件只能是值，不能是取值范围！
 * 
 * 说明：
 * 1、当多个case语句处理的语句块一致时，可以统一来书写
 * 2、swith-case与if-else之间可以相互转换
 */
import java.util.Scanner;
 
public class Test_Switch {

    public static void main(String[] args) {
        //switch_Char();
        //switvh_Score();
        //switch_Month();
        switch_YearMonthDay();
    }

    //例题1:使用switch把小写类型的char型转为大写。只转换a,b,c,d,e,其他的输出“other”
    public static void switch_Char() { 
        Scanner str = new Scanner(System.in); 
        System.out.println("请输入一个小写字母:");
        char c = str.next().charAt(0);           //从键盘获取单个字符的方法

        switch(c){
            case 'a': System.out.println((char)(c - 32)); break; 
            case 'b': System.out.println((char)(c - 32)); break; 
            case 'c': System.out.println((char)(c - 32)); break; 
            case 'd': System.out.println((char)(c - 32)); break; 
            case 'e': System.out.println((char)(c - 32)); break; 
            default : System.out.println("other");break;
        }
           

    }

    //例题2:对学生成绩大于60分的，输出“合格”。低于60分的，输出“不合格”。
    public static void switch_Score() {
        Scanner str = new Scanner(System.in);
        System.out.println("请输入学生的分数:");
        int score = str.nextInt();
        switch(score / 60){
            case 0: System.out.println("不合格");break;
            case 1: System.out.println("合格");break;
        }

    }

    //例题3:根据指定月份，打印该月份所属的季节。3,4,5春季，6,7,8夏季，9,10,11秋季，12,1,2冬季
    public static void switch_Month() {
        Scanner str = new Scanner(System.in);
        System.out.println("请输入月份:");
        int month = str.nextInt();
        switch(month){
            case 3:
            case 4:
            case 5:
                System.out.println("春季");break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");break;  
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");break;  
        }
        
    }

    //编写程序：从键盘上输入2019年的“month”和“day”，要求通过程序输出输入的日期为2019年的第几天
    public static void switch_MonthDay() {
        Scanner str = new Scanner(System.in);
        System.out.println("输入月: ");
        int month = str.nextInt();
        System.out.println("输入日: ");
        int day = str.nextInt();
        int sum = 0;                 //用来记录天数
        switch(month){
            case 12: sum += 30;     //11月天数
            case 11: sum += 31;     //10月天数 
            case 10: sum += 30;     //9月天数
            case 9: sum += 31;      //8月天数
            case 8: sum += 31;      //7月天数
            case 7: sum += 30;      //6月天数
            case 6: sum += 31;      //5月天数
            case 5: sum += 30;      //4月天数
            case 4: sum += 31;      //3月天数
            case 3: sum += 28;      //2月天数
            case 2: sum += 31;      //1月天数
            case 1: sum += day;
        }
        System.out.println(month + "月" + day + "日是2019年的第" + sum + "天");
    }

    //编写程序：从键盘上输入“year”，“month”和“day”，要求通过程序输出输入的日期为year年的第几天
    public static void switch_YearMonthDay() {
        Scanner str = new Scanner(System.in);
        System.out.println("输入年: ");
        int year = str.nextInt();
        System.out.println("输入月: ");
        int month = str.nextInt();
        System.out.println("输入日: ");
        int day = str.nextInt();
        int sum = 0;                 //用来记录天数
        switch(month){
            case 12: sum += 30;     //11月天数
            case 11: sum += 31;     //10月天数 
            case 10: sum += 30;     //9月天数
            case 9: sum += 31;      //8月天数
            case 8: sum += 31;      //7月天数
            case 7: sum += 30;      //6月天数
            case 6: sum += 31;      //5月天数
            case 5: sum += 30;      //4月天数
            case 4: sum += 31;      //3月天数
            case 3: 
                if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){
                    sum += 29;      //闰年29天
                }else{
                    sum += 28;      //平年28天
                }
                
            case 2: sum += 31;      //1月天数
            case 1: sum += day;
        }
        System.out.println(year + "年" + month + "月" + day + "日是" + year +"年的第" + sum + "天");
    }
}

