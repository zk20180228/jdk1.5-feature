package cn.cmcc.enumdemo.h;

/**
 * @Auther: zk
 * @Date: 2018/12/24 16:55
 * @Description:
 */
public enum Meal {


    //菜的分类
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private  final Food[] values;


    Meal(Class<? extends Food> kind) {
        //通过class对象获取枚举实例 values = kind.getEnumConstants();
        values = kind.getEnumConstants();
    }




}
