package cn.cmcc.annotation.e;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: zk
 * @Date: 2018/12/25 15:58
 * @Description: 表注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface DBTable {

    String name() default "";


}
