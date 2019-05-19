package timu;
/**
 * TIMu_Practice
 * 一些算法题目的练习
 */
public class TiMuPractice1 {

    public static void main(String[] args) {
        //Arrary();
        //find_Element(new int[]{-1, 2, 8, 10, 34, 88, 90, 92}, 92);  //将数组传入
        //test_Student();
        //bubble_Sort();
        String s = "caozhang nihao";
        reverse_Char(s);
        String[] strs = s.split(" ");
        reverse_String(strs);
        int[] int_arr = new int[]{-1, 1, -90, 199, 3, -8, 5, 3, 100, -7};
        System.out.println("冒泡排序:");
        bubble_Sort(int_arr);
        System.out.println("直接选择排序1:");
        select_Sort1(int_arr);
        System.out.println("直接选择排序2:");
        select_Sort2(int_arr);
        
    }

    /**
     * 定义类Primitive,在类中定义一个有3个元素的boolean类型的数组t作为其成员变量,数组元素未赋值
     * 1.定义一个方法test_Primitive(),在该方法中创建Primitive对象d,输出其成员变量的三个元素值.
     * 2.给对象d成员变量t赋值为{true, true, true},并输出t的三个元素值.
     */
    public static void test_Primitive() {
        Primitive d = new Primitive();
        for(int i = 0; i < d.t.length; i++){
            System.out.println(d.t[i]);
        }
        d.t[0] = true;
        d.t[1] = true;
        d.t[2] = true;
        for(int i = 0; i < d.t.length; i++){
            System.out.println(d.t[i]);
        }
    }

    /**
     * 定义类Student,包含三个属性:学号number(int),年级state(int),成绩score(int).创建20个学生对象,学号为
     * 1到20,年级和成绩都有随机数确定,打印出3年级(state值为3)的学生信息.
     * 提示:生成随机数:Math.random(),返回值类型double;
     *      四舍五入取整:Math.round(double d),返回值类型为long.
     */
    public static void test_Student() {
        Student[] stu = new Student[20];
        for(int i = 0; i < stu.length; i++){
            stu[i] = new Student(i, (int)((Math.random() * 3) + 1), (int)(Math.random() * 100));    //给每个元素初始化
        }
        for(int i = 0 ; i < stu.length; i++){   //输出3年级学生的信息
            if(stu[i].state == 3){
                System.out.println("年级: " + stu[i].state + "学号: " + stu[i].number + "成绩: " + stu[i].score);
            }
        }
    }
   
     /**
      * 数组中涉及的常见算法
        1.求数组元素的最大值,最小值,平均数,总和等
        2.数组的复制,反转
        3.数组元素的排序
      */
    public static void Arrary() {
        int[] arr = new int[]{12, 43, 9, 0, -65, -99, 100, 9};

        //最大值
        int max = arr[0];
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("arr数组的最大值为: " + max);

        //最小值
        int min = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("arr数组的最小值为: " + min);

        //总和
        int sum = 0;
        for(int i = 0 ; i < arr.length; i++){
            sum += arr[i];
        }
        System.out.println("arr数组的总和为: " + sum);

        //平均值
        double avg = sum / arr.length ;
        System.out.println("arr数组的平均值为: " + avg); 

        //数组的复制,将array1的值复制到array2,并将arrary2的偶数索引值变成其值
        int[] arrary1, arrary2;
        arrary1 = new int[]{12, 3, -9, 34, 8, 99, 108};

        //不能直接将arrary1赋值给arrary2,因为arrary1中存储的是堆中的内存地址,这样两个数组指向的是同一个地址,存储同一个数组值
        // arrary2 = arrary1;
        // for(int i = 0 ; i < arrary1.length; i++){
        //     if(i % 2 ==0){
        //         arrary2[i] = i;
        //     }
        // }
        // for(int i = 0 ; i < arrary2.length; i++){      //遍历输出arrary2
        //     System.out.print(arrary2[i] + "\t");
        // }
        // System.out.println();
        // for(int i = 0 ; i < arrary1.length; i++){      //遍历输出arrary2
        //     System.out.print(arrary1[i] + "\t");
        // }
        // System.out.println();
        
        arrary2 = new int[arrary1.length];    //在堆空间中开辟新的空间
        for(int i = 0; i < arrary1.length; i++){
            if(i % 2 == 0){
                arrary2[i] = i;
            }else{
                arrary2[i] = arrary1[i];
            }
        }
        System.out.println("arrary2: ");
        for(int i = 0 ; i < arrary2.length; i++){
            System.out.print(arrary2[i] + "\t");
        }
        System.out.println();
        System.out.println("arrary1: ");
        for(int i = 0 ; i < arrary1.length; i++){
            System.out.print(arrary1[i] + "\t");
        }
        System.out.println();

        //数组元素反转
        //第一种
        for(int x = 0, y = arr.length - 1; x < y; x++, y--){
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "\t");
        }

      }

    //二分法找出指定的数在数组中的索引
    public static void find_Element(int arr[], int key) {
        int low = 0;          //数组索引最小值
        int height = arr.length - 1;   //数组索引最大值 
        while(low <= height){
            int mid = (low + height)/ 2;
            if(key == arr[mid]){
                System.out.println(mid);
                break;
            }else if(key > arr[mid]){
                low = mid + 1;
            }else{
                height = mid -1;
            }
        }
        
    }
    
    //冒泡排序
    //排序思想:相邻两元素进行比较,如有需要则进行交换,每完成一次循环就将最大元素排在最后(如从小到大排序),
    //下一次循环是将其他的数进行类似操作
    public static void bubble_Sort(int[] ints){
        for(int i = 0 ; i < ints.length - 1; i++){                         //轮数`
            for(int j = 0; j < ints.length - 1 - i; j++){                  //j是每轮比较次数
                int temp = ints[j];
                if(ints[j] > ints[j + 1]){
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            } 
        }
        //遍历输出ints数组
        for(int i = 0 ; i < ints.length; i++){
            System.out.print(ints[i] + "\t");
        }
        System.out.println();
    }

    //直接选择排序
    public static void select_Sort1(int[] ints){
        for(int i = 0; i < ints.length - 1; i++){
            for(int j = i + 1; j < ints.length; j++){             
                if(ints[i] > ints[j]){
                    int temp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = temp;
                }
            }
        }
        //遍历输出ints数组
        for(int i = 0 ; i < ints.length; i++){
            System.out.print(ints[i] + "\t");
        }
        System.out.println();
    }

    //直接排序第二个版本
    public static void select_Sort2(int[] ints) {
        for(int i = 0; i < ints.length - 1; i++){
            int t = i;                //默认i处为最小值
            for(int j = i + 1; j < ints.length; j++){
                if(ints[t] > ints[j]){
                    t = j;
                }
            }
            if(t != i){
                int temp = ints[t];
                ints[t] = ints[i];
                ints[i] = temp;
            }

        }
        //遍历输出ints数组
        for(int i = 0 ; i < ints.length; i++){
            System.out.print(ints[i] + "\t");
        }
        System.out.println();
    }

    //字符串反转
    public static void reverse_Char(String str) {
        char[] strArray = str.toCharArray();    //将字符串转换为字符数组
        for(int i = 0; i < strArray.length / 2; i++){
            char temp = strArray[i];
            strArray[i] = strArray[strArray.length - 1 - i];
            strArray[strArray.length - 1 - i] = temp;
        }
        String str_after = String.valueOf(strArray);
        System.out.println("Before: " + str);
        System.out.println("After: " + str_after);
    }

    //单词反转
    public static void reverse_String(String[] strs) {
        for(int i = 0; i < strs.length / 2; i++){
            String temp = strs[i];
            strs[i] = strs[strs.length - 1 - i];
            strs[strs.length - 1 - i] = temp;
        }
        for(int i = 0; i < strs.length; i++){
            System.out.print(strs[i] + " ");
        }
        System.out.println();
    }
}

class Primitive{
    boolean[] t = new boolean[3];
}

class Student{
    int number;
    int state;
    int score;
    public Student(int number, int state, int score){
        this.number = number;
        this.state = state;
        this.score = score;
    }
}