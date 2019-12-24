/**
 * @Auther: zk
 * @Date: 2018/12/12 17:56
 * @Description: 测试值交换
 */
public class TestSwapValue {


    public static void main(String[] args) {

        //
        swapValue01(10,5);
        swapValue02(10,5);
        swapValue03(10,5);
    }


    public static void swapValue01(int a,int b){

        int temp=b;
        b=a;
        a=temp;
        System.out.println(a);
        System.out.println(b);
    }


    public static void swapValue02(int a,int b){

        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println(a);
        System.out.println(b);
    }


    public static void swapValue03(int a,int b){

            a=a^b;
            b=a^b;
            a=a^b;
            System.out.println(a);
            System.out.println(b);

    }



}
