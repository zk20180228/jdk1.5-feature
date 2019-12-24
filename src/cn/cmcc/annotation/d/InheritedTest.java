package cn.cmcc.annotation.d;

import java.lang.annotation.*;
import java.lang.reflect.AnnotatedType;
import java.util.Arrays;

/**
 * @Auther: zk
 * @Date: 2018/12/25 14:19
 * @Description: @Inherited 元注解 定义注解在使用时具有继承性，即继承了 具有该注解的注解的类，便继承了该注解
 */
public class InheritedTest {


    public static void main(String[] args) {
        // 测试@Inherited
        B b = new B();
        Annotation[] annotations = b.getClass().getAnnotations();
        //[@cn.cmcc.annotation.d.DocumentA(name=xx, value=aa)]
        System.out.println(Arrays.toString(annotations));

        D d = new D();
        Annotation[] annotations1 = d.getClass().getAnnotations();
        //[]
        System.out.println(Arrays.toString(annotations1));

        //通过反射获取元素上的注解--->Class,Method,Constructor,Field,Package 都实现了AnnotatedElement

        Class aClazz=B.class;

        //获取所有注解，包含从父类继承的注解
        Annotation[] ans01 = aClazz.getAnnotations();
        for(Annotation an:ans01){
            if(an instanceof DocumentA){
                DocumentA da= (DocumentA) an;
                System.out.println(da.name());//xx
                System.out.println(da.value());//aa
            }
        }

        //获取指定类型的注解
        Annotation asn02 = aClazz.getAnnotation(DocumentA.class);
        if(asn02!=null){
            DocumentA da= (DocumentA) asn02;
            System.out.println(da.value());//aa
            System.out.println(da.name());//xx
        }


        //获取所有注解，不包含从父类继承的注解
        Annotation[] asn03 = aClazz.getDeclaredAnnotations();
        System.out.println(Arrays.toString(asn03));//[]

        Annotation asn04 = aClazz.getDeclaredAnnotation(DocumentA.class);
        if(asn04!=null){//asn04==null
            System.out.println("获取指定类型的注解，不包含父类继承的注解!");
        }

        boolean isHasAns = aClazz.isAnnotationPresent(DocumentA.class);
        if(isHasAns){//isHasAns=true
            System.out.println("cn.cmcc.annotation.d.B包含了DocumentA.class");
        }

        //获取所有重复声明的指定类型的注解，当且仅当，该注解是Inherited类型，且当前类不存在该类型的注解时，才会找父类继承过来的该类型注解
        Annotation[] asn05 = aClazz.getAnnotationsByType(DocumentA.class);
        for(Annotation an:asn05){
            DocumentA da= (DocumentA) an;
            System.out.println(da.name());//xx
            System.out.println(da.value());//aa
        }


        //返回了当前类直接实现的接口
        AnnotatedType[] annotatedInterfaces = aClazz.getAnnotatedInterfaces();
        for(AnnotatedType anf:annotatedInterfaces){//annotatedInterfaces==null
            System.out.println(anf.getType().getTypeName()+".......");
        }

        //返回了当前类的直接父类
        AnnotatedType annotatedSuperclass = aClazz.getAnnotatedSuperclass();
        //cn.cmcc.annotation.d.A-------------
        System.out.println(annotatedSuperclass.getType().getTypeName()+"-------------");


    }

}


@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@interface DocumentA{

    String name() default "xx";

    String value() default "aa";
}


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@interface  DocuemntB{

    String name() default "";

    String value() default "";

}

@DocumentA()
class A{

}



class B extends A implements F{

}

@DocuemntB()
class C{

}

class D extends C{

}


interface  F extends G{

}

interface G{

}