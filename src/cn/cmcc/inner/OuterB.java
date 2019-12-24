package cn.cmcc.inner;

/**
 * @Auther: zk
 * @Date: 2018/12/19 10:23
 * @Description:
 */
public class OuterB {

        public String name="张三";
        private int age =28;
        public static final String contry="中国";

        public OuterB(){}

        public OuterB(String name,int age){
            this.name=name;
            this.age=age;
        }

        //成员内部类可以拥有private访问权限、protected访问权限、public访问权限及包访问权限。
        public class InnerB{

            public String name="李四";
            //如果想声明成静态，非静态内部类只能生命static final类型的常量，访问方式：OuterB.InnerB.contry
            /**
             * 常量会在编译阶段确定值，我们将这样的常量称之为编译期常量，而编译期常量是不需要加载类的字节码文件的，很多书上将这一步称之为编译期常量折叠
             */
            public static final String contry="美国";
            //public static final double c=Math.random();//编译报错：必须是编译时常量

            //编译会报错，非静态内部类数属于实例变量，静态优于对象加载，因此无法声明静态成员，但是可以声明static final 类型的静态常量
            //public static  int height=170;

            //访问外部类成员
            public void print(){
                System.out.println(this.name);
                System.out.println(this.contry);

                //访问外部类成员
                System.out.println(OuterB.this.name);
                System.out.println(OuterB.contry);
                System.out.println(OuterB.this.age);

                System.out.println(name);
                System.out.println(contry);
            }
        }


        //静态方法只能访问静态成员，包括静态内部类
        public  InnerB getInnerBInstance(){

            return new InnerB();// new OuterB().new InnerB();
        }


    public static void main(String[] args) {

        OuterB outerB = new OuterB();
        InnerB innerBInstance = outerB.getInnerBInstance();
        //李四
        //国
        //张三
        //中国
        //28
        //李四
        // 美国
        innerBInstance.print();

        //访问静态常量
        System.out.println(OuterB.InnerB.contry+"............");
        //System.out.println(OuterB.InnerB.height+"............");

        //当前类内部创建内部类对象时可以省略OuterA.，但是在外部创建内部类的时候就不能省略，建议不要省略
        OuterA.InnerA innerA = new OuterA().new InnerA();
    }


}
