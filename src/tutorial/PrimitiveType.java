package tutorial;
/*
 * java两大数据类型：
 *     内置数据类型(byte(8位), short(16位), int(32位), long(64位), float(32位), double(64位), char(16)）,还有一种类型：void，无法对其直接操作
 *     引用数据类型
 */
public class PrimitiveType {

    public static void main(String[] args) {
        //byte
        System.out.println("基本类型byte二进制位数: " + Byte.SIZE);
        System.out.println("Max: " + Byte.MAX_VALUE);
        System.out.println("Min: " + Byte.MIN_VALUE);
        System.out.println();
        
        //short
        System.out.println("基本类型short二进制位数: " + Short.SIZE);
        System.out.println("Max: " + Short.MAX_VALUE);
        System.out.println("Min: " + Short.MIN_VALUE);
        System.out.println();

        //int
        System.out.println("基本类型int二进制位数: " + Integer.SIZE);
        System.out.println("Max: " + Integer.MAX_VALUE);
        System.out.println("Min: " + Integer.MIN_VALUE);
        System.out.println();

        //long
        System.out.println("基本类型long二进制位数: " + Long.SIZE);
        System.out.println("Max: " + Long.MAX_VALUE);
        System.out.println("Min: " + Long.MIN_VALUE);
        System.out.println();

        //float
        System.out.println("基本类型float二进制位数: " + Float.SIZE);
        System.out.println("Max: " + Float.MAX_VALUE);
        System.out.println("Min: " + Float.MIN_VALUE);
        System.out.println();

        //double
        System.out.println("基本类型double二进制位数: " + Double.SIZE);
        System.out.println("Max: " + Double.MAX_VALUE);
        System.out.println("Min: " + Double.MIN_VALUE);
        System.out.println();

        //char
        System.out.println("基本类型char二进制位数: " + Character.SIZE);
        System.out.println("Max: " + (int)Character.MAX_VALUE);
        System.out.println("Min: " + (int)Character.MIN_VALUE);
        System.out.println();

        //final 修饰常量,常量是不可修改的
        final double PI = 3.1415927;

        //byte、int、long、和short都可以用十进制、16进制以及8进制的方式来表示。
        int decimal = 100;
        int octal = 0144;      //8进制
        short hexa =  0x64;    //16进制
        System.out.println("value of octal: " + octal);
        System.out.println("value of hexa: " + hexa);

        char a = '\u0001';
        System.out.println(a);
        float l1 = 12.3f;            //申明float型的变量，后面要加发f或F，不然会报错
        System.out.println(l1);     


        /*
         * 自动类型转换
         * 整型、实型（常量）、字符型数据可以混合运算。运算中，不同类型的数据先转化为同一类型，然后进行运算。
         * 转换从低级到高级。
         * 低  ------------------------------------>  高
         * byte,short,char—> int —> long—> float —> double 
         * 数据类型转换必须满足如下规则：
         * 1. 不能对boolean类型进行类型转换。
         * 2. 不能把对象类型转换成不相关类的对象。
         * 3. 在把容量大的类型转换为容量小的类型时必须使用强制类型转换。
         * 4. 转换过程中可能导致溢出或损失精度，例如：
         * int i =128; 
         * byte b = (byte)i; byte类型的最大值是127
         * 5. boolean类型的值只能是True或False，不可以以0或非0代替Flase和True，这点和C语言不同
         */

    }
} 