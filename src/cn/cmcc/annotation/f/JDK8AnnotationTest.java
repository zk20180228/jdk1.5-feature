package cn.cmcc.annotation.f;



import java.lang.annotation.*;

@DocumentA("/user/listAll")
@DocumentB("/account/list")
class Parent{

}

/**
 * @Auther: zk
 * @Date: 2018/12/25 17:48
 * @Description: 关于注解 JDK 1.8的新特性
 *
 * 元注解@Repeatable是JDK1.8新加入的，它表示在同一个位置重复相同的注解。
 * 在没有该注解前，是无法在同一个类型上使用相同的注解的
 *
 *Java8后，新增的TYPE_PARAMETER可以用于标注类型参数，
 * 而TYPE_USE则可以用于标注任意类型(不包括class)
 *
 *TYPE_PARAMETER 标注在类型参数上----->T:类型参数   D<T>:参数化类型
 *  class D<@Parameter T> { }
 *
 */
@DocumentA("/user/list")
@DocumentA("/user/queryList")
public class JDK8AnnotationTest extends Parent {

    public static void main(String[] args) {

        Class clazz01=JDK8AnnotationTest.class;
        //获取所有重复声明的指定类型的注解，当且仅当，该注解是Inherited类型，且当前类不存在该类型的注解时，才会找父类继承过来的该类型注解
        Annotation[] documentA01 = clazz01.getAnnotationsByType(DocumentA.class);
        for(Annotation an:documentA01){
            DocumentA da= (DocumentA) an;
            System.out.println(da.value());
        }
        System.out.println("===============================");
        //获取重复声明的指定类型的注解，忽略继承
        Annotation[] documentA02 = clazz01.getDeclaredAnnotationsByType(DocumentA.class);
        for(Annotation an:documentA02){
            DocumentA da= (DocumentA) an;
            System.out.println(da.value());
        }


    }

}
//@DocumentB("/account/delete")
//@DocumentB("/account/open")
class  AnnotationTest extends Parent{


    public static void main(String[] args) {
        Class clazz01=AnnotationTest.class;
        //获取所有重复声明的指定类型的注解，当且仅当，该注解是Inherited类型，且当前类不存在该类型的注解时，才会找父类继承过来的该类型注解
        Annotation[] DocumentB01 = clazz01.getAnnotationsByType(DocumentB.class);
        for(Annotation an:DocumentB01){
            DocumentB da= (DocumentB) an;
            System.out.println(da.value());
        }
        System.out.println("===============================");
        //获取重复声明的指定类型的注解，忽略继承
        Annotation[] DocumentB02 = clazz01.getDeclaredAnnotationsByType(DocumentB.class);
        for(Annotation an:DocumentB02){
            DocumentB da= (DocumentB) an;
            System.out.println(da.value());
        }
    }
}


//TYPE_PARAMETER 标注在类型参数上----->T:类型参数   D<T>:参数化类型
class D<@Parameter T> { }


@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_PARAMETER})
@interface Parameter{

}