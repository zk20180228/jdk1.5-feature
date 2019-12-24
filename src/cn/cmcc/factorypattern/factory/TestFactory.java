package cn.cmcc.factorypattern.factory;


/**
 * @Auther: zk
 * @Date: 2018/12/18 14:14
 * @Description:
 */
public class TestFactory {

    public static void main(String[] args) {
        HpMouseFactory hpMouseFactory = new HpMouseFactory();
        Mouse mouse = hpMouseFactory.createMouse();
        mouse.sayHi();

        DelMouseFactory delMouseFactory = new DelMouseFactory();
        Mouse delMouse = delMouseFactory.createMouse();
        delMouse.sayHi();
    }

}
