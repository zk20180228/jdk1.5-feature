package cn.cmcc.enumdemo.j;

/**
 * @Auther: zk
 * @Date: 2018/12/24 17:43
 * @Description:  枚举序列化是由jvm保证的，通过反射不能创建枚举对象
 */
public enum SingletonEnum {

    INSTANCE;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
