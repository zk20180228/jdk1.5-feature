package cn.cmcc.annotation.f;

import java.lang.annotation.*;

/**
 * @Auther: LENOVO
 * @Date: 2018/12/25 18:25
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Repeatable(DocumentAs.class)//没有Repeatable注解，是不允许同一个元素，使用多次相同的注解
@interface  DocumentA{

    String value() default "";
}
