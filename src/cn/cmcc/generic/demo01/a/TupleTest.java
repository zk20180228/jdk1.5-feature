package cn.cmcc.generic.demo01.a;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zk
 * @Date: 2018/12/21 14:18
 * @Description:
 *
 */
public class TupleTest {

    // java泛型类不能持有泛型类型的静态变量和方法，可以声明成静态泛型方法，需要在返回值前声明
    public static void main(String[] args) {

        TwoPule<String, Integer> twoPule = new TwoPule<String, Integer>("马云",48);
        System.out.println(twoPule);


        ThreePule<Integer, String, String> threePule = new ThreePule<Integer, String, String>(2,"张三","上海");
        System.out.println(threePule.toString());


        //泛型不是协变的（具有子父：类似于多态，子类对象指向父类引用）
        List<Integer> list01=new ArrayList<>();
        //下面的两句都会报错
        //List<Object> list02=list01;
        //List<Number> list02=list01;

    }

}
