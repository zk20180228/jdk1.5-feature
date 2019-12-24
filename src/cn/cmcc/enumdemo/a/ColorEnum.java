package cn.cmcc.enumdemo.a;

/**
 * @Auther: zk
 * @Date: 2018/12/24 10:00
 * @Description: 蔑枚举
 */
//使用enum来声明枚举，默认形况下Enum是所有枚举的基类
// public enum ColorEnum 经编译器处理后变成，public fianl class ColorEnum extends Enum<ColorEnum> 因此枚举类是final类，不可被继承
// Enum 是一个抽象类：有一个私有的成员：private final String name; name是枚举的常量名
public enum  ColorEnum {

    //以下是三个枚举实例。通过调用无参的构造函数生成。经编译器处理，会调用父类唯一的一个,只有2个参数的构造函数
    //枚举的构造函数是私有的，无法在外部创建枚举实例
    //枚举常量名:RED,YELLOW,BLACK
    //常数的序数:0,1,2
    //经编译器处理后如下：
    /**
     *   public static ColorEnum[] values()
         {
         return (ColorEnum[])$VALUES.clone();
         }
         //根据实例名获取实例
         public static ColorEnum valueOf(String s)
         {
         return (ColorEnum)Enum.valueOf(ColorEnum, s);
         }

     * public static final ColorEnum RED;
     * public static final ColorEnum YELLOW;
     * public static final ColorEnum BLACK;
     * private static final ColorEnum[] $VALUES;
     *
     * static{
     *  RED=new ColorEnum("RED",0);
     *  YELLOW=new ColorEnum("YELLOW",1);
     *  BLACK=new ColorEnum("BLACK",2);
     *  $VALUES=new ColorEnum[]{RED,YELLOW,BLACK};
     * }
     *
     *
     */
    RED,YELLOW,BLACK;

    public static void main(String[] args) {

        ColorEnum[] values = ColorEnum.values();

        for (ColorEnum e:values){
            System.out.println(e);//打印的是枚举的常量名
            ColorEnum colorEnum = ColorEnum.valueOf(e.toString());//根据枚举常量名获取枚举对象
            System.out.println(colorEnum);
            int ordinal = e.ordinal();
            System.out.println(ordinal);
            Class<ColorEnum> declaringClass = e.getDeclaringClass();
            System.out.println(declaringClass.getSimpleName());//ColorEnum
        }


    }

}

