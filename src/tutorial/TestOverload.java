package tutorial;
/**
 * TestOverload
 * 方法的重载(Overload)
 * 要求:1.方法在同一类中,2.方法名必须相同,3.方法的参数列表不同(1.参数类型不同,2.参数个数不同)
 * 补充:方法的重载与方法的返回值类型没有关系.
 */
public class TestOverload {
    public static void main(String[] args) {
        Overload method = new Overload();
        System.out.println(method.getSum(12, 13));
        System.out.println(method.getSum(12, 13, 14));
        System.out.println(method.getSum(12.0, 13));
        method.getSum(12.1, 13, 2.0);
    }
}

class Overload{
    //定义两个int型变量的和
    public int getSum(int i, int j){
        return i + j;
    }

    //定义三个int型变量的和  
    public int getSum(int i, int j, int k){
        return i + j + k;
    }

    //定义两个double型数据的和
    public double getSum(double d1, double d2){
        return d1 + d2;
    }

    //定义三个double型数据的和
    public void getSum(double d1, double d2, double d3){
        System.out.println(d1 + d2 + d3);
    }
}