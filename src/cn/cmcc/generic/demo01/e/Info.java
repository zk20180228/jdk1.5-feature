package cn.cmcc.generic.demo01.e;

/**
 * @Auther: zk
 * @Date: 2018/12/21 17:41
 * @Description:
 */
public class Info<T> {


   private T t;

   public Info(T t){
       this.t=t;
   }

   //因为Info也是泛型类，但是我们不确定Info的泛型类型，因为此用？代替,其实？类似于Object
   public void print(Info<?> info){
       System.out.println(info);
   }

    @Override
    public String toString() {
        return t.toString();
    }


    public static void main(String[] args) {
        Info<String> info01 = new Info<String>("哈哈");
        info01.print(info01);//哈哈

        Point<String> p = new Point<>();
        p.setT("Tom");
        Info<Point<String>> info02 = new Info<Point<String>>(p);
        info01.print(info02);//Point{t=Tom}
    }



}
