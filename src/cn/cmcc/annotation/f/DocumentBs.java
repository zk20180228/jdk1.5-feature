package cn.cmcc.annotation.f;

import java.lang.annotation.*;

/**
 * @Auther: zk
 * @Date: 2018/12/25 18:26
 * @Description:
 */

@Inherited////必须都是Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface DocumentBs {

    DocumentB[] value();
}
