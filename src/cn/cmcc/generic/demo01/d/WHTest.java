package cn.cmcc.generic.demo01.d;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zk
 * @Date: 2018/12/21 16:55
 * @Description: 泛型的问号:如:T表示泛型,?表示不确定类型，其实和T的左右很相似,但是T 的具体度更详细
 * ?可以理解为任意类型(Object类型)，不确定的类型
 * 场景:当一个泛型类，使用着另一个泛型类，这时候，我们不确定被使用的泛型类的具体类型，就可以使用？，其实和Object一样的
 * ? extends Number
 */
public class WHTest<T> {

    public void print01(List<? extends T> list){
        for (T t :list) {
            System.out.println(t);
        }
    }

    public void print02(List<? super T> list){

        for(Object obj:list){
            System.out.println(obj);
        }

    }


    public void print03(List<? extends Object> list){

        for(Object obj:list){
            System.out.println(obj);
        }

    }

    public List<?> getList(T t){

        if(t!=null){
            return new ArrayList<T>();
        }

        return new ArrayList<T>();
    }





}
