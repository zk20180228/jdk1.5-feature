package cn.cmcc.generic.demo01.e;

/**
 * @Auther: zk
 * @Date: 2018/12/21 17:39
 * @Description:
 */
public class Notepad<K,V> {

    private K k;
    private V v;

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }


    @Override
    public String toString() {
        return "Notepad{" +
                "k=" + k +
                ", v=" + v +
                '}';
    }

    public static void main(String[] args) {
        Notepad<Integer, String> notepad = new Notepad<>();
        notepad.setK(200);
        notepad.setV("哈哈");
        System.out.println(notepad);
    }


}
