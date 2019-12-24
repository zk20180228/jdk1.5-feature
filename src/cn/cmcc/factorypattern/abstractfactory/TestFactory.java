package cn.cmcc.factorypattern.abstractfactory;


/**
 * @Auther: zk
 * @Date: 2018/12/18 14:14
 * @Description:
 */
public class TestFactory {

    public static void main(String[] args) {
        HpFactory hpFactory = new HpFactory();
        Keybo keybo = hpFactory.createKeybo();
        keybo.sayHi();
        Mouse mouse = hpFactory.createMouse();
        mouse.sayHi();

        DelFactory delFactory = new DelFactory();
        Keybo keybo1 = delFactory.createKeybo();
        keybo1.sayHi();
        Mouse mouse1 = delFactory.createMouse();
        mouse1.sayHi();

    }

}
