/**
 * @Auther: LENOVO
 * @Date: 2018/12/12 17:09
 * @Description:
 */
public class TestString {

    /**
     * @auther: zhangkui
     * @desc:  字符串是常量,而且是引用类型,它们的值在创建之后不能更改,
     *          创建出的字符串将存放在数据区，保证每个字符串常量只有一个
     * @date: 2018/12/12 17:10
     * @param: 
     * @return: 
     */
    public static void main(String[] args) {


        String str1="abc";
        String str2="abc";
        String str3="a"+"bc";//实际上至少有三个对象a,bc,abc
        String str4=new String("abc");//每次new 都是新的



        System.out.println(str1==str2);//true
        System.out.println(str1==str3);//true
        System.out.println(str1==str4);// false

    }

}
