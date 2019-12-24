package cn.cmcc.enumdemo.e;

/**
 * @Auther: zk
 * @Date: 2018/12/24 16:24
 * @Description:
 */
public enum Week {


    //枚举对象的定义必须放在第一行，且一次一句定义完
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");

    private final String desc;
    Week(String desc){
        this.desc=desc;
    }

    //enum中只有着一个方法不是final的,因此子类只能重写着一个方法
    @Override
    public String toString() {
        return this.desc;
    }

    public String getDesc() {
        return desc;
    }

    public static void main(String[] args) {
        Week[] values = Week.values();
        for(Week we:values){
            System.out.println(we);
        }
    }

}
