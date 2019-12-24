package cn.cmcc.annotation.e;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: zk
 * @Date: 2018/12/25 16:00
 * @Description:
 * 约束注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Constraints {

    boolean primarykey() default false;//是否作为主键约束

    boolean allowNull() default false;//是否允许为null

    boolean unique() default false;//是否为一


}
