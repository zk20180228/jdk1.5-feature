/**
 * @Auther: zk
 * @Date: 2018/12/18 10:25
 * @Description:  父类的static变量和函数在派生类中依然可用，但是受访问性控制（比如，父类的private域中的就不可访问），
 *               而且对static变量来说，派生类和父类中的static变量是共用空间的，这点在利用static变量进行引用计数的时候要特别注意。
 */
public class TestStatic02 {

    public  static String str ="小丑";

    public static void printStr(){

        System.out.println(str);
    }

    public static String getStr() {
        return str;
    }

    public static void setStr(String str) {
        TestStatic02.str = str;
    }
}
