/**
 * @Auther: LENOVO
 * @Date: 2018/12/12 17:28
 * @Description:
 */
public class TestSanYuan {


    public static void main(String[] args) {
        int a =100;

        System.out.println(a>100?"老子大于100！":"老子还没100大，呜呜。。。。");

        //取模结果不一定就是整数
        double b =2.8;
        double c=0.5;

        double d=b%c;
        System.out.println(d);//0.2999999999999998

        System.out.println("5+5="+5+5);//5+5=55

        System.out.println('*'+'\t'+'*');//93
        System.out.println("*"+"\t"+"*");//*	*

        int i=1;
            i*=0.1;
            i++;
        System.out.println(i);//1


        // 任何一个数异或一个数2次都是其本身
        //2 << 空出来的位补0,>>补的值取决于最高位,>>>补0
        int aa=10;
        System.out.println(aa^10^10);//10
        System.out.println(aa<<2);//40



    }
}
