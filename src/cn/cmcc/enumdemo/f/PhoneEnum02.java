package cn.cmcc.enumdemo.f;

/**
 * @Auther: zk
 * @Date: 2018/12/24 16:35
 * @Description:
 */
public enum PhoneEnum02 {

    XIAOMI("雷军"){
        @Override
        public void getInfo() {
            System.out.println("小米手机，因发烧而生！");
        }
    },
    HUAWEI("任正非"){
        @Override
        public void getInfo() {
            System.out.println("华为手机，大家说好!");
        }
    },
    APPLE("库克"){
        @Override
        public void getInfo() {
            System.out.println("苹果手机,什么鬼系统，贼流畅！");
        }
    },
    CHUIZI("老罗"){
        @Override
        public void getInfo() {
            System.out.println("锤子手机,你是安卓手机的市场牺牲品！");
        }
    };

    private final String CEO;

    PhoneEnum02(String ceo){
        this.CEO=ceo;
    }

    public abstract void getInfo();


    public static void main(String[] args) {
        for(PhoneEnum02 ph:PhoneEnum02.values()){
            ph.getInfo();
        }
    }






}
