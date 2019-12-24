package cn.cmcc.factorypattern.abstractfactory;

/**
 * @Auther: zk
 * @Date: 2018/12/18 14:25
 * @Description:
 */
public class HpKeybo implements Keybo {
    @Override
    public void sayHi() {
        System.out.println("Hp键盘，肌肤般的手感！");
    }
}
