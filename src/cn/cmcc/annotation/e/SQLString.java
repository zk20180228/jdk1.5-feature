package cn.cmcc.annotation.e;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: zk
 * @Date: 2018/12/25 16:24
 * @Description:  注解String类型的字段
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface SQLString {

    //对应数据库表的列名
    String name() default "";
    //列类型分配的长度，如varchar(30)的30
    int value() default 0;
    //字段约束
    Constraints constraint() default @Constraints;

}
