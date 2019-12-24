package cn.cmcc.factorypattern.abstractfactory;

/**
 * @Auther: zk
 * @Date: 2018/12/18 14:09
 * @Description: 惠普鼠标
 */
public class HpMouse implements Mouse {

    @Override
    public void sayHi() {
        System.out.println("Hp鼠标,值得信赖！");
    }
}
