package cn.cmcc.enumdemo.g;

/**
 * @Auther: zk
 * @Date: 2018/12/24 16:49
 * @Description:
 */
public enum  InterfaceEnum implements Food,Sport {

    FIRST,SECOND;

    @Override
    public void eat() {
        System.out.println("民以食为天-----");
    }

    @Override
    public void run() {
        System.out.println("生命不止，运动不息---------");
    }

}
