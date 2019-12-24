package cn.cmcc.enumdemo.c;

/**
 * @Auther: zk
 * @Date: 2018/12/24 11:24
 * @Description:
 */
public class EnumDemo01 {

    // 当枚举在另一个类内部，那么，该枚举相当于静态内部类。编译后:static enum Week
    enum Week{
        MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {

        Week monday = EnumDemo01.Week.MONDAY;
        System.out.println(monday);


        int i = Week.MONDAY.compareTo(Week.THURSDAY);
        int c = Week.SUNDAY.compareTo(Week.MONDAY);
        System.out.println(c);//>0  6-0=6 按照枚举声明的顺序来比较
        System.out.println(i);//<0  0-3=-3

        System.out.println(Week.MONDAY==Week.MONDAY);//true
        System.out.println(Week.MONDAY==Week.THURSDAY);//false

        Enum week = Week.valueOf(Week.MONDAY.name());
        System.out.println(week);//MONDAY

        //枚举与Class对象
        try {
            Class<Week> clazz = week.getDeclaringClass();
            if(clazz.isEnum()){//判断此Class对象是否是枚举类型
                Week[] enumConstants = clazz.getEnumConstants();//通过Class获取枚举对象的常量
                for(Week ek:enumConstants){
                    System.out.println(ek+"------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }




    }



}
