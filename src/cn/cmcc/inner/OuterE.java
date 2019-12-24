package cn.cmcc.inner;

/**
 * @Auther: zk
 * @Date: 2018/12/19 11:24
 * @Description: 静态内部类：只能是在成员位置，因为局部内部类是不能用用static 修饰
 */
public class OuterE {

    public String name="zhang";

    public static final String CONTRY="中国";

    public static class InnerE{

        public static int a=8;
        //静态内部类也可以有自己的非静态成员
        public String talk="哈哈";

        public void print(){

            //System.out.println(OuterE.this.name);//编译报错，静态内部类只能访问外部类的静态成员
            System.out.println(talk);
            System.out.println(CONTRY);
            System.out.println("inner........................");
        }
    }

    public static  InnerE getInnerInstance(){

        return new OuterE.InnerE();
    }


    public static void main(String[] args) {

        //方式一
        OuterE.InnerE innerInstance = OuterE.getInnerInstance();
        System.out.println(innerInstance);

        //方式二:当前类有效,不建议
        OuterE.InnerE innerE = new InnerE();
        System.out.println(innerE);

        //方式三:
        OuterE.InnerE innerE1 = new OuterE.InnerE();

        //访问静态内部类静态变量
        System.out.println(OuterE.InnerE.a);

    }

}
