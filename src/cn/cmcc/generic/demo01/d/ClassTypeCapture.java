package cn.cmcc.generic.demo01.d;

/**
 * @Auther: zk
 * @Date: 2018/12/21 16:18
 * @Description:
 */
public class ClassTypeCapture<T extends Building> {

    Class<T> clazz;

    public ClassTypeCapture(Class<T> clazz){
        this.clazz=clazz;
    }

    public  void isInstanceOf(Object object){
        //相当于:object instanceof T
        System.out.println(clazz.isInstance(object));
    }


    public static void main(String[] args) {

        ClassTypeCapture<House> houseClassTypeCapture = new ClassTypeCapture<House>(House.class);
        houseClassTypeCapture.isInstanceOf(new House());

        ClassTypeCapture<Building> buildingClassTypeCapture = new ClassTypeCapture<Building>(Building.class);

        buildingClassTypeCapture.isInstanceOf(new House());
        //instanceof 具有多态性,协变性
        System.out.println(new House() instanceof Building);
    }



}
