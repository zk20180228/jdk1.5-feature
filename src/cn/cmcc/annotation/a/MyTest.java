package cn.cmcc.annotation.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: zk
 * @Date: 2018/12/25 10:22
 * @Description: 自定义@Test注解
 */
@Retention(RetentionPolicy.RUNTIME)//元注解：注解的生命周期
@Target({ElementType.METHOD})//元注解：注解的作用范围
public @interface MyTest {

    Class<? extends MyException> clazz() default MyTest.MyException.class;

    long timeout() default 0l;

    public static class MyException extends Throwable{
        private static final long serialVersionUID = 1L;

    }

}
