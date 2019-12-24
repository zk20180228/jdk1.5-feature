package cn.cmcc.inner;

/**
 * @Auther: zk
 * @Date: 2018/12/19 15:33
 * @Description: 匿名内部类访问外部局部变量(好像不包含当前类的成员变量)，外部变量需要声明为final类型。
 * 如果自己不加，编译器会自动加上，但是不允许手动修改变量值
 */
public class OuterF {

    private  int a =5;
    private  Person person=new Person();

    public  void testThread( int b){

        new Thread(){
            @Override
            public void run() {
                System.out.println(b);
                person=new Person();
                System.out.println(person);
            }
        }.start();

        //编译会报错
        //b=5;

    }

    public static void main(String[] args) {
        new OuterF().testThread(10);
    }


}
