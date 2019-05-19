package tutorial;
/**
 * TestCar
 * 用来练习对象作为参数的传递
 */
public class TestCar {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.name = "劳斯莱斯";
        c1.wheel = 4;  
        
        Factory f = new Factory();
        Car c2 = f.produceCar("玛莎拉蒂", 6); 
        f.describeCar(c2);
    }
    
} 

class Factory{ 
    //制造车,方法重载
    public Car produceCar(){
        return new Car();
    }

    public Car produceCar(String n, int w) {
        Car c = new Car();
        c.name = n;
        c.wheel = w;
        return c;
    }

    public void describeCar(Car c){
        c.info();
    }
}

class Car{
    String name;
    int wheel;

    public void info() {
        System.out.println("name: " + name + " " + "wheel: " + wheel);
    }

    public void setName(String n ){
        name = n;
    }

    public void setWheel(int w){
        wheel = w;
    } 
}