/**
 * @Auther: LENOVO
 * @Date: 2018/12/17 18:40
 * @Description:
 */
public abstract  class ABC01 {

    int a =10;
    int c,d=20,e,f=30;//声明c,d,e,f四个变量，并非且d赋值为20,f赋值为30.其余的没有赋值，具有默认值

    public ABC01(int a) {
        this.a = a;
    }

    public ABC01() {
       a++;
    }
}
