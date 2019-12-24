package cn.cmcc.reflect.d;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Auther: zk
 * @Date: 2018/12/27 10:23
 * @Description:
 *
 * java.lang.reflect.Array:它提供了动态创建和访问 Java 数组的方法。Array 允许在执行 get 或 set 操作进行取值和赋值
 *
 *
 */
public class ArrayReflectTest {

    public static void main(String[] args) {

        int[] ints={1,3,5,7,9,11};

        //获取数组类型的Class 即：int.class
        Class<?> intComponentType = ints.getClass().getComponentType();

        //创建一个新的数组,第一个参数：int.class，第二个参数，数组的长度
        Object ints02 = Array.newInstance(intComponentType, 10);

        //获取原数组的长度
        int intsLength = Array.getLength(ints);

        //把原数组的值copy到新数组
        System.arraycopy(ints,0,ints02,0,intsLength);

        //[1, 3, 5, 7, 9, 11, 0, 0, 0, 0]
        System.out.println(Arrays.toString((int[])ints02));


        Class<String> strClass=String.class;

        //创建一个String[]类型的数组
        String[] strs = (String[]) Array.newInstance(strClass, 10);

        strs[1]="哈哈";

        Array.set(strs,0,"hello");
        //[hello, 哈哈, null, null, null, null, null, null, null, null]
        System.out.println(Arrays.toString(strs));

        String str  = (String) Array.get(strs, 1);//哈哈
        System.out.println(str);




    }





}
