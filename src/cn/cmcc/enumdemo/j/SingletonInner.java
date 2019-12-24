package cn.cmcc.enumdemo.j;

/**
 * @Auther: zk
 * @Date: 2018/12/24 17:34
 * @Description:
 */
public class SingletonInner {

    public static class Inner{
        private static final Inner inner =new Inner();
    }

    private SingletonInner(){

    }

    public static Inner  getInnerInstance(){

        return Inner.inner;
    }


}
