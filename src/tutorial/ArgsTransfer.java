package tutorial;
/**
 * ArgsTransfer
 * 方法的参数传递(重点,难点)
 * 1.形参:方法申明时,方法小括号内的参数
 *   实参:调用方法时,实际传入的参数的值
 * 
 * 2.规则:java中的参数传递机制,值传递机制
 *   1)形参是基本数据类型的:将实参的值传递给形参的基本数据类型的变量
 *   2)形参是引用数据类型的:将实参的引用数据类型变量的值(对应的堆空间的对象实体的首地址值)传递给形参的引用数据类型变量
 */
public class ArgsTransfer {
	
    public static void main(String[] args) {
        ArgsTransfer A = new ArgsTransfer();
        A.first();
    }

    public void first(){
        int i = 5;
        Value v = new Value(); 
        v.i = 25;
        second(v, i);
        System.out.println(v.i);
    }

    public void second(Value v, int i){
        i = 0;
        v.i = 20;
        Value val = new Value();
        v = val;
        System.out.println(v.i + "" + i);
    }
}

class Value{
    int i = 15;

}

