package cn.cmcc.generic.demo01.e;

import java.util.List;

/**
 * @Auther: zk
 * @Date: 2018/12/21 18:13
 * @Description:
 */
public interface Computer<B,T extends Person<?>,E extends Integer> {

    void print(T t,E e);

    void printList(List<B> list);

    //泛型方法
    <F extends Number> void read(List<F> f);

}
/**
 *
 public interface Computer<T extends Person<String>,E extends Integer> {

 void print(T t,E e);

 void printList(List<?> list);

 }
 或
 public interface Computer<B,T extends Person<B>,E extends Integer> {

 void print(T t,E e);

 void printList(List<B> list);

 }
 或者
 public interface Computer<T extends Person<?>,E extends Integer> {

 void print(T t,E e);

 void printList(List<?> list);

 }

 由此可见,?和T 的区别:当一个泛型类使用另一个泛型类时，当我们确定类型时，就指定类型，
 当我们不确定类型时，也不想声明新的泛型类型时，可以用？。
 ?主要用在当一个泛型类使用另一个泛型类，但是我们不知道这另一个泛型类的具体类型时，我们可以用？来代替，避免编译器警报
 当我们不想用？,可以声明一个泛型，给这个泛型类使用

 泛型的不确定性在编译期有效，但是一旦编译完成，那么泛型会擦出，使用泛型的声明会变成具体类型
 *
 *
 *
 *
 *
 */