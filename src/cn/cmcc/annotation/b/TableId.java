package cn.cmcc.annotation.b;

import java.lang.annotation.*;

/**
 * @Auther: zk
 * @Date: 2018/12/25 10:39
 * @Description:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface TableId {

    String value() default "";
    IdType type() default IdType.NONE;

    enum IdType{

        AUTO(0),
        NONE(1),
        INPUT(2),
        ID_WORKER(3),
        UUID(4),
        ID_WORKER_STR(5);

        private final  int key;
        private IdType(int key){
            this.key=key;
        }

        public int getKey() {
            return key;
        }
    }
}
