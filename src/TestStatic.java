/**
 * @Auther: LENOVO
 * @Date: 2018/12/13 18:46
 * @Description:
 */
public class TestStatic {

    //静态方法只能访问静态变量，非静态方法可以访问静态成员
    private static int a=5;
    public void print(){
        System.out.println(a);
    }

}
