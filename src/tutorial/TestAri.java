package tutorial;
/**
 * 测试算术运算符: + — * / % ++ --
 */
public class TestAri {

    public static void main(String[] args) {
        //除：/
        int i = 13;
        int j = 5;
        double b1 = i / j ;
        double b2 = i / (-5);
        double b3 = i / 5.0;
        System.out.println(b1); //2
        System.out.println(b2); //-2
        System.out.println(b3); //2.6
        System.out.println();

        //取模： % 余数的符号与被模数的符号相同
        int i1 = 13 % 5;
        int i2 = 13 % (-5);
        int i3 = -13 % 5;
        int i4 = -13 % (-5);
        System.out.println(i1); //3
        System.out.println(i2); //3
        System.out.println(i3); //-3
        System.out.println(i4); //-3
        System.out.println();

        //前++:先自加1，后做运算
        //后++:先做运算，后自加1
        int myInt1 = 10;
        int myInt2 = myInt1++;
        System.out.println(myInt1); //11
        System.out.println(myInt2); //10

        int myInt3 = 10;
        int myInt4 = ++myInt3;
        System.out.println(myInt3); //11
        System.out.println(myInt4); //11
        System.out.println();

        //前--:先自减1，后做运算
        //后--:先做运算，后自减1
        int myInt5 = 10;
        int myInt6 = myInt5--;
        System.out.println(myInt5); //9
        System.out.println(myInt6); //10

        int myInt7 = 10;
        int myInt8 = --myInt7;
        System.out.println(myInt7); //9
        System.out.println(myInt8); //9
        System.out.println();
    }
}