/**
 * @Auther: zk
 * @Date: 2018/12/12 16:29
 * @Description:
 */
public class TestException {


    public static void main(String[] args) {

        try {
            int rs=3/0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("执行了catch块。。。。。。。。。。");
        }

        System.out.println("不管是否发生异常，我都会执行！");

        char a='\u0002';
        System.out.println(a);


    }


}
