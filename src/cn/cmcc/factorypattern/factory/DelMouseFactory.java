package cn.cmcc.factorypattern.factory;

/**
 * @Auther: zk
 * @Date: 2018/12/18 14:19
 * @Description:
 */
public class DelMouseFactory implements MouseFactory {

    @Override
    public Mouse createMouse() {
        return new DelMouse();
    }
}
