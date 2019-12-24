package cn.cmcc.reflect.a;

/**
 * @Auther: zk
 * @Date: 2018/12/26 10:57
 * @Description:
 *  RRTI:Run-Time Type Identification-->运行时类型识别
 *  Class:在java中用来表示运行时类型信息,所有类的字节码表示形式都是其实例。该类对象
 *  由JVM来创建,每一个对象都是单例的,代表某一个类的运行时信息
 *
 * Class对象是由JVM加载的，那么其加载时机是？实际上所有的类都是在对其第一次使用时动态加载到JVM中的，
 * 当程序创建第一个对类的静态成员引用时，就会加载这个被使用的类(实际上加载的就是这个类的字节码文件),即Class
 * 对象，类的对象的创建完全依赖Class对象(JVM来做这件事);
 *
 */
public class ClassTest {

    //所有的类都是在对其第一次使用时动态加载到JVM中的
    public static void main(String[] args) {
        System.out.println("start");
        new Candy();//jvm加载Canday,创建Candy.class
        System.out.println(" after Candy");
        try {
            Class.forName("cn.cmcc.reflect.a.Gum");//jvm加载Gum,创建Gum.class
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("after Class.forName()");
        new Cookie();//jvm加载Cookie,创建Cookie.class
        //Class<Cookie> cookieClass = Cookie.class;//这种方式不会初始化该类
        //获取Class对象的三种方式
        Class first=Candy.class;
        Class second=new Candy().getClass();

        try {
            Class third=Class.forName("cn.cmcc.reflect.a.Candy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //基本数据类型的Class
        //        char.class = Character.TYPE;
        //        byte.class = Byte.TYPE;
        //        short.class = Short.TYPE;
        //        int.class = Integer.TYPE;
        //        long.class = Long.TYPE;
        //        float.class = Float.TYPE;
        //        double.class = Double.TYPE;
        //        void.class = Void.TYPE;


        //boolean.class 代表boolen类型的Class对象   Boolean.class 代表Boolean类型的Class对像
        Class<Boolean> boolen01 =Boolean.TYPE;
        Class boolen02=boolean.class;
        Class<Boolean> boolean03=Boolean.class;
        System.out.println(boolen01==boolen02);//true
        System.out.println(boolen01==boolean03);//flase
        System.out.println(boolen02==boolean03);//flase

        //int.class代表int类型的Class对象，Integer.class代表Integer类型的Class对象
        Class<Integer> int01 =Integer.TYPE;
        Class int02=int.class;
        Class<Integer> int03=Integer.class;
        System.out.println(int01==int02);//true
        System.out.println(int01==int03);//flase
        System.out.println(int02==int03);//flase

        



    }


}




class Candy{
    static{
        System.out.println("loading Candy-------");
    }
}

class Gum{

    static{
        System.out.println("loading Gum---------");
    }

}

class Cookie{

    static{
        System.out.println("loading Cookie-------");
    }
}