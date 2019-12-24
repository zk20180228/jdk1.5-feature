/**
 * @Auther: LENOVO
 * @Date: 2018/12/17 17:17
 * @Description:
 */
public class Parent {

    private String name="爸爸";

    public String getName02() {
        return getName();
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getName(){
        return this.name;
    }

}
