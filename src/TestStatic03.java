/**
 * @Auther: zk
 * @Date: 2018/12/18 10:26
 * @Description:
 */
public class TestStatic03  extends TestStatic02{

   //@Override
   public static void  printStr(){


   }


    /*  父类的static变量和函数在派生类中依然可用，但是受访问性控制（比如，父类的private域中的就不可访问），
        而且对static变量来说，派生类和父类中的static变量是共用空间的，这点在利用static变量进行引用计数的时候要特别注意。
        另外，静态成员 父类和子类的共享空间，子类是不能进行重写静态方法的,加@Override，会报错
    */
    public static void main(String[] args) {
        TestStatic03.str="哈哈";

        TestStatic03.printStr();
        System.out.println(TestStatic03.str);
        System.out.println(TestStatic02.str);
    }
}
