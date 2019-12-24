package cn.cmcc.generic.demo01.d;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zk
 * @Date: 2018/12/21 16:34
 * @Description:
 */
public class CreateGenericArrayTest<T> {

    public  T[] tryCreateArray(T t){

        //T[] tt= new T[]{t};//编译报错，不能
        return  null;
    }

    //我们会用创建集合替代创建数组
    public List<T> getList(T t){

        List<T> ts = new ArrayList<>();
        ts.add(t);
        return  ts;
    }







}
