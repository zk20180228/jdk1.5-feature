import java.io.*;

/**
 * @Auther: zk
 * @Date: 2018/12/14 16:05
 * @Description:
 */
public class TestMath {

    public static void main(String[] args) throws IOException {

        double a=2.3;

        System.out.println(a);//2.3 注意 double类型打印的时候带'.'
        System.out.println(Math.ceil(a));//3.0返回值类型为double  double类型打印的时候带'.'
        System.out.println(Math.floor(a));//2.0返回值类型为double double类型打印的时候带'.'
        System.out.println(Math.round(a));//2 返回值为long 所以不带'.'

        double b=-2.5;
        System.out.println(b);//-2.5
        System.out.println(Math.ceil(b));//-2.0
        System.out.println(Math.floor(b));//-3.0
        System.out.println(Math.round(b));//-2 说明当是负数时,0.5会被舍弃

        Runtime runtime = Runtime.getRuntime();
        runtime.exit(0);

    }

}
