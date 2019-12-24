package cn.cmcc.annotation.e;

/**
 * @Auther: zk
 * @Date: 2018/12/25 16:27
 * @Description: 数据库表Member对应实例类bean
 */
@DBTable(name = "MEMBER")
public class Member {

    @SQLString(value = 50,name = "ID",constraint = @Constraints(primarykey = true))
    private String id;

    @SQLString(value = 30)
    private String name;

    @SQLInteger()
    private Integer age;

    @SQLString(name = "DESC",value = 500,constraint = @Constraints(allowNull = true))
    private String desc;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
