package cn.cmcc.annotation.b;

/**
 * @Auther: zk
 * @Date: 2018/12/25 10:54
 * @Description:
 */
@TableName("t_sys_student")
public class Student {

    @TableId(value = "id",type= TableId.IdType.AUTO)
    private  String id;

    //value 元素的特殊性 当且仅当只给value元素指定值时，可省略value=
    @TableFiled("name")
    private  String name;
    @TableFiled("age")
    private  int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
