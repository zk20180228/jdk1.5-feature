/**
 * @Auther: zk
 * @Date: 2018/11/27 10:11
 * @Description: 测试算数运算符
 */
public class TestArithmetic {

    public static void main(String[] args){
        //不同类型的数参与运算时，首先看类型是否要提升，如果要提升，先提升类型，后参与运算
        int i =12;
        int j=5;
        int d1=i/j;//2
        double d2=i/j;//2.0
        double d3 =i/5.0;//2.4
        System.out.println(d1);//默认整型
        System.out.println(d2);//先运算在升为double
        System.out.println(d3);//先提升类型在参与运算

        //取模，结果取决于被模数
        int m1=i%j;//2
        int m2=-i%j;//-2
        int m3=-i%-j;//-2
        int m4=i%-j;//2
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
        System.out.println(m4);


        //前++：先自身运算，再参与运算，前--同理
        //后++，先参与运算，后进行自身于运算，后--同理

        //不管是前++，--，还是后++，--，最总自己都会参与运算，结果一致
         int a =10;
         int b=9;

         int c=++a;
         int e=a++;

         int f=--b;
         int g=b--;

        System.out.println(c);//11
        System.out.println(e);//11  因为之前已经自增1
        System.out.println(f);//8
        System.out.println(g);//8   因为之前已经自1
        System.out.println(a);//12
        System.out.println(b);//7









    }


}
