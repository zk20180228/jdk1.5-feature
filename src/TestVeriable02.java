/**
 * @Auther: zk
 * @Date: 2018/11/28 18:02
 * @Description:测试算术运算
 * 1 自动类型转化
 * 2 强制类型转换
 */
public class TestVeriable02 {



    public static void main(String[] args){

        //1.自动类型转换:当容量小的数据类型与容量大的数据类型做运算时，容量小的会自动转换为
        //容量大的数据类型:byte,char,short ===>int ===>long ===>float===double
        int a=12;
        short b=12;
        int c=a+b;
        System.out.println(c);//24
        float d=10.0f+c;
        System.out.println(d);//34.0
        float e= (float) (d+0.0);//默认为double类型，需要强制类型转换-->34.0
        System.out.println(e);//-->34.0
        long f=2l;
        float g=d+f;//long的容量要小于float,double
        System.out.println(g);//36.0
        char h='a';
        System.out.println(h);//a
        System.out.println(h+1);//97+1=98
        int i='A'+1;
        System.out.println(i);//65+1=66

        //需要注意的：当char\byte\short之间做运算时，默认的结果为int类型

        byte j=10;
        short k=10;
        short l= (short) (j+k);//byte,char,short之间作运算时，默认结果是int,因此需要强制类型转换
        System.out.println(l);//20

        byte m= (byte) 128;//丢失精度 -128
        System.out.println(m);// -128

        //题目:任何基本类型和字符串相加结果都是字符串，+ 相当于连接符

        String str="hello";
        char n='a';//97
        int o=12;
        System.out.println(str+n+o);//helloa12
        System.out.println(n+o+str);//109hello--->97+12+"hello"--->109hello
        System.out.println(str+o+n);//hello12a


    }




}
