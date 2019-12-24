package cn.cmcc.factorypattern.abstractfactory;

/**
 * @Auther: zk
 * @Date: 2018/12/18 14:24
 * @Description:
 */
public class DelKeybo implements Keybo {

    @Override
    public void sayHi() {
        System.out.println("Del键盘，就是好！");
    }
}
