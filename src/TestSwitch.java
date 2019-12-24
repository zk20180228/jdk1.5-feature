/**
 * @Auther: zk
 * @Date: 2018/12/12 14:43
 * @Description:
 */
public class TestSwitch {


    public static void main(String[] args) {

        /**
         * 1 如果都不匹配，执行default,如果default有break结束，没有会继续按顺序往下执行，直到遇到break或者全部执行完，结束
         * 2 如果匹配，且有break,执行完匹配的，结束
         * 3 如果匹配的五break,会继续按顺序往下执行，
         *      包含可能提前遇到default,直到遇到break或全部执行完（包含default）结束
         *
         */
        //testSwitch01();
        testDoWhile();
        testSwitch02();

    }


    /**
     * @auther: zhangkui
     * @desc: 尽量每个case技术都要break,包括default
     * @date: 2018/12/12 15:00
     * @param: 
     * @return: 
     */
    public static void testSwitch01(){

        int i =2;
        switch(i){
            case 1:
            case 2:
                System.out.println("1或2");
                //break;
            case 3:
            case 4:
                System.out.println("3或4");
                //break;
            default:
                System.out.println("都没中，哈哈");
                //break;
            case 5:
                System.out.println("5,哈哈你猜对了");

        }

    }



    static void testDoWhile(){

        int i=-1;
        do{
            System.out.println("我一定会先执行一次！");
        }while(i>0);


    }


    static void testWhileDo(){
        int i=-1;
        while(i>0){
            System.out.println("我是执行不到的！");
        }

    }


    public static void  testSwitch02(){

        String season="summer";
        switch(season){
            case "spring"://case后的值必须是常量
                System.out.println("春天");
                break;
            case "summer":
                System.out.println("夏天");
                break;
            case "autumn":
                System.out.println("秋天");
                break;
            case "winter":
                System.out.println("冬天");
                break;
            default://default子句是可任选的
                System.out.println("季节输入有误！");
                break;

        }





    }



}
