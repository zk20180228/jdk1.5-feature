package cn.cmcc.generic.demo01.e;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: zk
 * @Date: 2018/12/21 18:16
 * @Description:
 */
public class ThinkPad implements Computer<String,Person<Number>,Integer> {


    @Override
    public void print(Person<Number> person, Integer integer) {
        person.getGodName(6);
        System.out.println(integer);
    }

    @Override
    public void printList(List<String> list) {
        for(String str:list){
            System.out.println(str);
        }
    }

    @Override
    public <F extends Number> void read(List<F> f) {
        for(Number n:f)
            System.out.println(n);
    }

    public void add(List<?> list){

        //list.add(new Info<String>("xx"));//编译报错
    }



    public static void main(String[] args) {
        ThinkPad thinkPad = new ThinkPad();
        thinkPad.read(Arrays.asList(new Integer[]{1,2,3}));
    }


}
