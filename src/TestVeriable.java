/**
 * @Auther: zk
 * @Date: 2018/11/28 17:29
 * @Description: 8种基本类型：byte char short int long double float boolean
 */
public class TestVeriable {

    static boolean initValue;//默认值false
    static byte initByte;//默认0
    static char initChar;//默认0代表的字符
    static short initShort;//默认0
    static int initInt;//默认0
    static long initlong;//默认0l
    static float initFloat;//默认：0.0
    static double initDouble;//默认0.0

    public static void main(String[] args){

        System.out.println(initValue);
        System.out.println(initByte);
        System.out.println((int)initChar);
        System.out.println(initShort);
        System.out.println(initInt);
        System.out.println(initlong);
        System.out.println(initFloat);
        System.out.println(initDouble);

        int a=10;
        double b=12.3;
        System.out.println(a);//10
        System.out.println(b);//12.3
        System.out.println(a+b);//22.3 会先进行类型提升，再运算
        byte c=12;
        //byte d =128;//编译报错 -128-127
        long d =13213123123l;
        System.out.println(c);//12
        System.out.println(d);//13213123123
        float e=12.33f;
        System.out.println(e);//12.33
        char f='\u1234';
        char g='\t';
        char h='\n';
        System.out.println(f);//ሴ
        System.out.println(g);//	制表符tab键
        System.out.println(h);//换行
        boolean flag=false;
        if(!flag){
            System.out.println("哈哈哈"+flag);
        }else{
            System.out.println("耶耶耶"+flag);
        }



        String str="哈哈哈哈\n\t"+"你猜我在哪？";
        /**
         * 哈哈哈哈
               你猜我在哪？
         */
        System.out.println(str);

        /**
         * 哈哈哈哈
           我猜不着！
         */
        String str2="哈哈哈哈\n"+"我猜不着！";
        System.out.println(str2);

    }



}
