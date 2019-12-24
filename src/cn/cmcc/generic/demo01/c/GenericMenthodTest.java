package cn.cmcc.generic.demo01.c;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zk
 * @Date: 2018/12/21 15:47
 * @Description:
 * 对于一个static 方法而言，是无法访问泛型类的参数化类型，因此可以使用泛型方法来解决这个问题。
 * 结论：泛型类不能持有静态泛型类型的成员，因为静态属于共享的。静态类不能持有静态泛型类型的成员方法，但可以声明为：泛型方法
 * */
public class GenericMenthodTest {

    //静态泛型方法
    public static <T> void print(T t){
        System.out.println(t);
    }


    //静态泛型方法和可变参数结合
    public static <B> List<B> makeList(B...b){

        List<B> bs = new ArrayList<>();
        for(B bb:b)
            bs.add(bb);
        return bs;

    }

    //123
    public static void main(String[] args) {
        print("123");

        List<String> list = makeList("张三", "里斯");
        System.out.println(list);
    }



}
