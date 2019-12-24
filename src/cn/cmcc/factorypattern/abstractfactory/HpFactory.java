package cn.cmcc.factorypattern.abstractfactory;

/**
 * @Auther: zk
 * @Date: 2018/12/18 14:19
 * @Description:
 */
public class HpFactory implements PcFactory {


    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Keybo createKeybo() {
        return new HpKeybo();
    }
}
