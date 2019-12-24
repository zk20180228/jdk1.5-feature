package cn.cmcc.generic.demo01.e;

/**
 * @Auther: zk
 * @Date: 2018/12/21 18:03
 * @Description:
 * 实现的时候可以指定，某一类，如B，因为B也是泛型，所以 需要泛型的声明：因此，我们可以声明<B>
 */
public class Person<B> implements GodTest<B> {

    @Override
    public void getGodName(B t) {
        System.out.println(t);
    }


    public static void main(String[] args) {
        //实例化的时候指定泛型的具体类型
        Person<String> person = new Person<>();
        person.getGodName("人类");//人类

    }


}
