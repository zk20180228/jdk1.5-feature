package cn.cmcc.enumdemo.f;

/**
 * @Auther: zk
 * @Date: 2018/12/24 16:30
 * @Description:
 */
public enum PhoneEnum {


    XIAOMI{
        @Override
        public void getInfo() {
            System.out.println("小米");
        }
    },
    HUAWEI{
        @Override
        public void getInfo() {
            System.out.println("华为");
        }
    },
    APPLE{
        @Override
        public void getInfo() {
            System.out.println("苹果");
        }
    },
    ZHONGXING{
        @Override
        public void getInfo() {
            System.out.println("中兴");
        }
    };

    public abstract void getInfo();


    public static void main(String[] args) {
        PhoneEnum[] values = PhoneEnum.values();
        for(PhoneEnum ph:values){
            ph.getInfo();
        }
    }


}
