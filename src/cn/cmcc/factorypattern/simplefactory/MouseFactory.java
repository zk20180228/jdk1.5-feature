package cn.cmcc.factorypattern.simplefactory;

/**
 * @Auther: zk
 * @Date: 2018/12/18 14:11
 * @Description:
 */
public class MouseFactory {

    /**
     * @auther: zhangkui
     * @desc: 工厂方法，一般为静态的
     * @date: 2018/12/18 14:15
     * @param: 
     * @return: 
     */
    public static Mouse createMouse(int m){
        Mouse mouse=null;
        if(m==1){
            mouse=new DelMouse();
        }else if(m==2){
            mouse=new HpMouse();
        }

        return mouse;
    }


}
