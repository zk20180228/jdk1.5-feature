package cn.cmcc.reflect.c;

import java.util.Date;

/**
 * @Auther: zk
 * @Date: 2018/12/26 16:13
 * @Description:
 */
public class User<T> {

    private T t;

    private String id;

    private String name;

    private int age;

    private Date brithday;

    private String userType;

    private  Class<String> clazz;

    private int[] ints;

    public User() {
    }


    public User(String name, int age, Date brithday,T t,Class<String> clazz,int[] ints) {
        this.name = name;
        this.age = age;
        this.brithday = brithday;
        this.t=t;
        this.clazz=clazz;
        this.ints=ints;
    }

    public User(String name, int age, Date brithday,T t,Class<String> clazz) {
        this.name = name;
        this.age = age;
        this.brithday = brithday;
        this.t=t;
        this.clazz=clazz;
    }


    public User(String name, int age, Date brithday,T t) {
        this.name = name;
        this.age = age;
        this.brithday = brithday;
        this.t=t;
    }

    private User(String name, int age, Date brithday) {
        this.name = name;
        this.age = age;
        this.brithday = brithday;
    }

    public User(String id, String name, int age, Date brithday, String userType) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.brithday = brithday;
        this.userType = userType;
    }

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

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", brithday=" + brithday +
                ", userType='" + userType + '\'' +
                '}';
    }
}
