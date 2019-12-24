package cn.cmcc.annotation.b;

import java.lang.annotation.*;

/**
 * @Auther: zk
 * @Date: 2018/12/25 10:46
 * @Description:
 *
 * @Documented 注解:定义在生成java文档时，是否带上该注解，即使用了该注解的java源文件生成api时，是否带上该注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface TableFiled {

    String value() default "";

    String el() default "";

    boolean exist() default true;

    String condition() default "";

    String update() default "";

    FieldStrategy strategy() default  FieldStrategy.NOT_NULL;

    FieldFill fill() default FieldFill.DEFAULT;

    boolean select() default true;

    enum FieldStrategy{
        IGNORED,
        NOT_NULL,
        NOT_EMPTY;
    }

    enum FieldFill{
        DEFAULT,
        INSERT,
        UPDATE,
        INSERT_UPDATE;
    }


}
