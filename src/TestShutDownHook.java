/**
 * @Auther: 测试main方法运行完毕，是否关闭虚拟机。结论：关闭虚拟机
 * @Date: 2018/12/17 13:42
 * @Description:
 */
public class TestShutDownHook {


    public TestShutDownHook(){
        this.doShutDownHook();
    }

    /**
     * @auther: zhangkui
     * @desc:  main,方法运行时，添加一个钩子函数，如果jvm关闭时，那么会待钩子函数运行完毕后，关闭虚拟机
     * @date: 2018/12/17 13:49
     * @param: 
     * @return: 
     */
    public void doShutDownHook(){
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.out.println("虚拟机，关闭了.................");
            }
        });
    }


    public static void main(String[] args) {

        new TestShutDownHook();

        for(int i=0;i<1000;i++){
            System.out.println(i);
        }
    }


}
