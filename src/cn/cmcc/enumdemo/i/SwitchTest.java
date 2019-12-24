package cn.cmcc.enumdemo.i;

/**
 * @Auther: zk
 * @Date: 2018/12/24 18:49
 * @Description:
 */
public class SwitchTest {



    public static void main(String[] args) {

        SwitchEnum.Color color= SwitchEnum.Color.YELLOW;

        switch(color){
            case RED://前边不需要加引用
                System.out.println("红色");
                break;
            case BLUE:
                System.out.println("蓝色");
                break;
            case YELLOW:
                System.out.println("黄色");
                break;
            default:
                System.out.println("其它颜色");
                break;
        }
    }
}
