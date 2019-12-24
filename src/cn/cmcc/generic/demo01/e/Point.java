package cn.cmcc.generic.demo01.e;

/**
 * @Auther: zk
 * @Date: 2018/12/21 17:36
 * @Description:
 */
public class Point<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Point{" +
                "t=" + t +
                '}';
    }

    public static void main(String[] args) {

        Point<String> point = new Point<>();
        point.setT("哈哈");
        System.out.println(point);//Point{t=哈哈}

        Point<Integer> point1 = new Point<>();
        point1.setT(2);
        System.out.println(point1);//Point{t=2}

    }


}
