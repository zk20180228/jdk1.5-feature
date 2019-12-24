package cn.cmcc.inner;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: zk
 * @Date: 2018/12/19 10:09
 * @Description:
 * 每个内部类都能独立地继承一个（接口的）实现，
 * 所以无论外围类是否已经继承了某个（接口的）实现，对于内部类都没有影响。
 * 如 抽象类A，抽象类B，和类C，类C无法实现抽象A，B所有的方法，因为java是单继承，
 * 当然，可以多继承来解决这个问题，但是更好的解决方案也许是内部类来实现。
 * 内部类最大的优点就在于它能够非常好的解决多重继承的问题
 */
public class OuterA {

    private Double a=1.0;

    public  class InnerA{

        public void print(){
            System.out.println(a);
        }

    }


    public static void main(String[] args) {

        //当前类内部创建内部类对象时可以省略OuterA.，但是在外部创建内部类的时候就不能省略，建议不要省略
        InnerA innerA=new OuterA().new InnerA();
        //标准的创建内部类对象
        OuterA.InnerA innerA1 = new OuterA().new InnerA();
        innerA.print();//1.0
        innerA1.print();

        Map<Object, Object> map = new HashMap<>();
        //Map.Entry<Object, Object>就是Map的内部接口
        //内部类的引用为(也可以理解为类名为,Outer.Inner)：Outer.Inner,如，xx extends Outer.Inner,如Class<Map.Entry> entryClass = Map.Entry.class;
        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        for(Map.Entry e:entries){
            System.out.println(e.getKey());
        }
    }

}
