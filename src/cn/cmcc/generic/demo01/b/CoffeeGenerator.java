package cn.cmcc.generic.demo01.b;

import java.util.Random;

/**
 * @Auther: zk
 * @Date: 2018/12/21 15:05
 * @Description:
 */
public class CoffeeGenerator implements Generator<Coffee> {


    Class[] clazz=new Class[]{Breve.class,Cappuccino.class,Latte.class,Mocha.class};

    @Override
    public Coffee next() {


        try {
            return (Coffee)clazz[new Random().nextInt(clazz.length)].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }



}
