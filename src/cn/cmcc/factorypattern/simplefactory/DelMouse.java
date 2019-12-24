package cn.cmcc.factorypattern.simplefactory;

/**
 * @Auther: zk
 * @Date: 2018/12/18 14:08
 * @Description: 戴尔的鼠标
 */
public class DelMouse implements Mouse {


    @Override
    public void sayHi() {
        System.out.println("Del鼠标，你，值得拥有！");
    }
}
