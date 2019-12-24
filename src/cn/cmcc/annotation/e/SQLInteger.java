package cn.cmcc.annotation.e;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: zk
 * @Date: 2018/12/25 16:20
 * @Description:注解Integer类型的字段
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface SQLInteger {

    //该字段对应数据库列名
    String name() default "";

    //字段约束
    Constraints constraint() default @Constraints;

}
