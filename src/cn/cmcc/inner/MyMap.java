package cn.cmcc.inner;

/**
 * @Auther: zk
 * @Date: 2018/12/19 17:29
 * @Description: 内部接口
 */
public interface MyMap {

    String M_D="呵呵";

    boolean put(String key,String value);

    /**
     * 默认情况下，内部接口是静态的，不管你是否手动加了static关键字
     */
     interface MyEntry{

          void print();

    }



}
