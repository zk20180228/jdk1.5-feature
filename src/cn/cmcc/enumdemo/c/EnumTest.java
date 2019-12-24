package cn.cmcc.enumdemo.c;

/**
 * @Auther: zk
 * @Date: 2018/12/24 11:29
 * @Description:
 */
public class EnumTest {


    public static void main(String[] args) {
        EnumDemo01.Week[] values = EnumDemo01.Week.values();
        for(EnumDemo01.Week w:values){
            System.out.println(w);
        }
    }
}
