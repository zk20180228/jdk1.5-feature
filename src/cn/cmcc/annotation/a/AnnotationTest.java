package cn.cmcc.annotation.a;

import org.junit.Test;

import java.util.Date;

/**
 * @Auther: zk
 * @Date: 2018/12/25 10:13
 * @Description:
 */
public class AnnotationTest {

    @Test
    public void test01(){
        System.out.println("@Test");
    }


    @Deprecated
    @SuppressWarnings("all")
    public void test02(){

        Date date = new Date();
        int i = date.getDate();

        System.out.println();
    }

}
