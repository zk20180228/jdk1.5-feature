package cn.cmcc.annotation.b;

import java.lang.annotation.*;

/**
 * @Auther: zk
 * @Date: 2018/12/25 10:36
 * @Description:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TableName {

    String value() default "";

    String resultMap() default "";
}
