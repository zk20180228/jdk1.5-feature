package cn.cmcc.inner;

/**
 * @Auther: zk
 * @Date: 2018/12/19 10:59
 * @Description: 匿名内部类
 * 一般来说，匿名内部类用于继承其他类或是实现接口，并不需要增加额外的方法，只是对继承方法的实现或是重写。
 */
public class OuterD {




    public abstract class InnerD{

        public void print(){
            System.out.println("hahaha.............");
        }

        public abstract void read();
    }



    public void readInner(InnerD inner){

        inner.print();
        inner.read();
    }


    public static void main(String[] args) {

        OuterD outerD = new OuterD();
        //匿名内部类
        outerD.readInner(new OuterD().new InnerD(){
            @Override
            public void print() {
                super.print();//hahaha.............
            }
            @Override
            public void read(){
                System.out.println("read......");//read......
            }
        });


        //说明内部类的成员访问修饰符对所在的外部类无效，但是对其他类是有效的
        System.out.println(OuterE.InnerE.a);
        //说明非静态内部类的静态常量，不需要对象即可访问你
        System.out.println(OuterB.InnerB.contry+"............");



    }

}





