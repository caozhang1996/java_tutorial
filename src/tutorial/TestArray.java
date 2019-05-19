package tutorial;
/**
 * Test_Arrary
 * 如何定义数组,使用数组.
 */
public class TestArray {
    public static void main(String[] args) {
        create_Array();
    }
 
    public static void create_Array() {
        //1:如何定义一个数组 
        //1.1:数组的申明
        String[] names; 
        int[] ages;

        //1.2初始化
        //第一种,静态初始化:初始化数组与给数组元素赋值同时进行
        names = new String[]{"Iron man", "Captain American", "Black Widow"};

        //第二种,动态初始化:初始化数组与给数组元素赋值分开进行
        ages = new int[4];
        //2.如何调用相应的数组元素:通过数组元素的下角标的方式来调用
        //下角标从0开始,到n-1结束,其中n表示数组的长度
        ages[0] = 44;
        ages[1] = 38;
        ages[3] = 32;
        System.out.println(names[0]);
        System.out.println(names[1]);
        System.out.println(names[2]);
        System.out.println(ages[0]);
        System.out.println(ages[1]);
        System.out.println(ages[2]);
        System.out.println(ages[3]);
        //3.通过length属性来得到数组的长度,数组一旦初始化,其长度是不可变的(数组的弊端)
        System.out.println("names数组的长度是: " + names.length);
        System.out.println("ages数组的长度是: " + ages.length);

        //4.遍历数组元素
        for(int i = 0; i < ages.length; i++){
            System.out.println(ages[i]);
        }

        //5.数组元素的默认初始化值
        //5.1:对于byte, short, int, long类型而言,默认初始化值为0
        //5.2:对于float, double类型的数据,默认值为0.0
        //5.3:对引用类型的变量构成的数组而言,默认值为null(以String为例)
        //5.4:对于char类型而言,默认值为空格
        //5.5:对于boolean类型而言,默认值为false
        float[] scores = new float[4];
        scores[1] = 90.0f;
        for(int i = 0; i < scores.length; i++){
            System.out.println(scores[i]);
        }
    }
    
    public static void two_Dims_Array() {
        
    }
    
}