package cn.cmcc.enumdemo.j;

/**
 * @Auther: zk
 * @Date: 2018/12/24 17:25
 * @Description: 这种方式1.5以后volatile，但并不完全保证线程安全
 */
public class SingletonLazy {

    //volatile
    private static volatile  SingletonLazy singletonLazy;

    private SingletonLazy(){

    }

    //双重检查锁
    public static SingletonLazy getInstance(){
        if(singletonLazy==null){
            synchronized (SingletonLazy.class){
                if(singletonLazy==null){
                    return  singletonLazy=new SingletonLazy();
                }
            }
        }
        return singletonLazy;
    }


}
