package cn.cmcc.annotation.f;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: LENOVO
 * @Date: 2018/12/25 18:25
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@interface DocumentAs{

    DocumentA[]  value();//必须为DocumentA[] 类型的 value()

}
