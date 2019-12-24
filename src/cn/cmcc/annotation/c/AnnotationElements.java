package cn.cmcc.annotation.c;

import java.lang.annotation.*;

/**
 * @Auther: zk
 * @Date: 2018/12/25 11:08
 * @Description:
 *
 * 注解的元素类型
 *
    所有基本类型,不允许使用任何包装类型（int,float,boolean,byte,double,char,long,short）
    String
    Class
    enum
    Annotation
    上述类型的数组
 *
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.METHOD,ElementType.TYPE,ElementType.PARAMETER})
//编译之后：public interface AnnotationElements extends Annotation
public @interface AnnotationElements {
    //枚举类型
    enum Status {FIXED,NORMAL};

    Status satus() default Status.NORMAL;

    boolean showSupport() default  false;

    String name() default "";

    Class<?> testCase() ;//default AnnotationElements.class;

    long[] value() ;

    Reference reference() default @Reference(value="xx",name="呵呵");


}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
@interface Reference{

    String name() default "";
    String value();
}

//注解是不允许继承的
//@interface  Son extends Reference{
//
//}