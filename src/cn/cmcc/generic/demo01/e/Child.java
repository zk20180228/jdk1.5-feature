package cn.cmcc.generic.demo01.e;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: zk
 * @Date: 2018/12/22 10:38
 * @Description:
 * 总结号的使用：
 * 1 ? 使用在形参位置，如 add(List<?> list)，代表不确定的类型，类似于Object
 * 2 声明变量，如 List<?> list 但是list添加元素的时候编译器会报错，说明？并不能当作Object类型使用，我们也不建议这么使用
 *    那怕我们声明称，List list 也可以
 * 3 ？常用在泛型的声明中，一个泛型类使用另一个泛型类，不确定类型的时候。但是不能直接当作类型形参使用，需要搭配extends ,super 如<B extends Info<?>>
 *
 * 1,3是？尝使用的地方，但是我们建议，1,3的情况下使用，2尽量不要使用
 *
 */
public class Child<B extends Info<?>> extends Person<B> {

    public static void main(String[] args) {

        //错误的使用方式，能声明变量，但是不能那个使用
        List<?> list =new ArrayList<>();
        //下面的两句编译报错,说明编译器不认识？,?不能当作Object类型使用.
        //list.add(1);
        //list.add("aa");

        for(Object o:list)
            System.out.println(o);//编译不报错，秩序遍历，不允许添加未知类型

        //类似于Object 参数化类型指定的是父类，是可以放子类的
        List<Person> people = new ArrayList<>();
        people.add(new Child());
        System.out.println(people);

        loophole(5);
    }


    public static String loophole(Integer x) {

        List<String> ys = new LinkedList<String>();

        List xs = ys;

        xs.add(x); // compile-time unchecked warning

        return ys.iterator().next();

    }



}
