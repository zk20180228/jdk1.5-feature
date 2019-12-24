package cn.cmcc.inner;

/**
 * @Auther: zk
 * @Date: 2018/12/19 10:46
 * @Description: 局部内部类：　局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内
 */
public class OuterC {

    private  String name;

    private  String contry="中国";

    private int age;


    public void print(){
        //局部内部类就像是方法里面的一个局部变量一样，是不能有public、protected、private以及static修饰符的
        class InnerC{
             private  String name="哈哈";
             private void read(){
                System.out.println(contry);
             }

        }


        System.out.println(new InnerC().name);
        new InnerC().read();
    }

    public Person getInnerPerson(){
            class InnerPerson extends Person{

                private String name="nihao";

                @Override
                void say() {
                    super.say();
                }
            }

            System.out.println(new InnerPerson().name);
            return new InnerPerson();
    }


    public static void main(String[] args) {
        new OuterC().print();

        Person innerPerson = new OuterC().getInnerPerson();
        innerPerson.say();

        System.out.println(innerPerson);
    }


}


class Person{


    void say(){
        System.out.println("hello.............");
    }
}