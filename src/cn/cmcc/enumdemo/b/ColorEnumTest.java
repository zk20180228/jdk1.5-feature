package cn.cmcc.enumdemo.b;
/**
 * @Auther: zk
 * @Date: 2018/12/24 11:07
 * @Description:
 */
public class ColorEnumTest {

    public static void main(String[] args) {
        ColorEnum red = ColorEnum.RED;
        System.out.println(red);
        System.out.println(red.getKey());

        ColorEnum[] values = ColorEnum.values();

        for(ColorEnum e:values){
            System.out.println(e.getKey());
        }

        ColorEnum redColorEnum = ColorEnum.valueOf("RED");
        System.out.println(redColorEnum);

    }


}
