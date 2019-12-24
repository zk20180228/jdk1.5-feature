package cn.cmcc.factorypattern.abstractfactory;

/**
 * @Auther: zk
 * @Date: 2018/12/18 14:17
 * @Description:工厂
 */
public interface PcFactory {

    Mouse createMouse();

    Keybo createKeybo();

}
