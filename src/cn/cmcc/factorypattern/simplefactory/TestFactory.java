package cn.cmcc.factorypattern.simplefactory;

/**
 * @Auther: zk
 * @Date: 2018/12/18 14:14
 * @Description:
 */
public class TestFactory {

    public static void main(String[] args) {
        Mouse mouse = MouseFactory.createMouse(1);
        mouse.sayHi();
    }

}
