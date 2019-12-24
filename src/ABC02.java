/**
 * @Auther: LENOVO
 * @Date: 2018/12/17 18:41
 * @Description:
 */
public class ABC02 extends ABC01 {

    public ABC02(){
        //默认会调用super()
    }

    public ABC02(int a) {
        super(a);
    }

    public static void main(String[] args) {
        ABC02 abc02 = new ABC02();
        System.out.println(abc02.a);
        System.out.println(abc02.e);

        ABC02 abc = new ABC02(100);
        System.out.println(abc.a);
    }



}
