package cn.cmcc.varagrs;

/**
 * @Auther: zk
 * @Date: 2018/12/21 10:21
 * @Description:
 */
public class TestVarargs<E>{
    // java泛型类不能持有泛型类型的静态变量和方法，可以声明成静态泛型方法，需要在返回值前声明
    //static  E e;

    public static void main(String[] args) {

        //调用可变参数可以不传参
        varargs01();
        //可变参数可以传递数组
        varargs01(new String []{"xx"});//编译器会做优化，相当于varargs01("xx")

        varargs01("2","3");
        varargs02(new String []{"a","b"});

        //支持泛型
        varargs03("呵呵");

        //可变参数是兼容数组类参数的，但是数组类参数却无法兼容可变参数
        //可变参数类型必须作为参数列表的最后一项，而不能放在定长参数的前面
        //能匹配定长的方法，那么优先匹配该方法

    }

    //static 方法无法识别泛型类的参数化类型，因此定义为泛型方法
    public   static <T> T varargs03(T...args){

        T tt=null;
        for (T t:args){
            System.out.println(t);
        }
        System.out.println();

        return tt;
    }




    //varargs01(String... args)和varargs01(String [] args)实际上是一样的，因此同属出现编译会报错
    //可变参数可以不传参
    public static void varargs01(String... args){

        for(String s:args){
            System.out.println(s);
        }
    }


    public static void varargs02(String [] args){

        for(String s :args){
            System.out.println(s);
        }

    }



}
