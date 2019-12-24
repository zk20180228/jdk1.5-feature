package cn.cmcc.enumdemo.j;

/**
 * @Auther: zk
 * @Date: 2018/12/24 17:23
 * @Description: 饿汉式:
 * 单例模式可能被破坏：1 ：反序列化可能会破坏单例模式 2 反射强行调用私有构造器
 */
public class SingletonHungry {

    private static SingletonHungry singletonHungry = new SingletonHungry();
    private SingletonHungry(){

    }

    public static SingletonHungry getInstance(){

        return singletonHungry;
    }

}
