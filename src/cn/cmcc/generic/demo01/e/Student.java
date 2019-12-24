package cn.cmcc.generic.demo01.e;

/**
 * @Auther: zk
 * @Date: 2018/12/21 18:06
 * @Description:
 */
public class Student implements GodTest<String> {


    @Override
    public void getGodName(String s) {
        System.out.println(s);
    }


    public static void main(String[] args) {
        //实现接口的时候指定泛型的具体类型
        new Student().getGodName("学生");
    }



}
