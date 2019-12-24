package cn.cmcc.factorypattern.abstractfactory;

/**
 * @Auther: zk
 * @Date: 2018/12/18 14:19
 * @Description:
 */
public class DelFactory implements PcFactory {

    @Override
    public Mouse createMouse() {
        return new DelMouse();
    }

    @Override
    public Keybo createKeybo() {
        return new DelKeybo();
    }
}
