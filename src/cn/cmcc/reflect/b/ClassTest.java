package cn.cmcc.reflect.b;

/**
 * @Auther: zk
 * @Date: 2018/12/26 15:20
 * @Description:
 *
 *  boolean isInstance(Object obj) ---->ojb instanceof T
 *
 *  T cast(Object obj)
 *
 *
 */
public class ClassTest {

    public static void main(String[] args) {

        Animal animal =new Dog();
        Class<Dog> dogClass=Dog.class;
        Dog dog = dogClass.cast(animal);//类型转换---相当于：Dog dog=(Dog)animal

        System.out.println(animal instanceof Dog);//true

        System.out.println(dogClass.isInstance(animal));//true--->相当于:animal instanceof Dog

        System.out.println(animal.getClass()==Dog.class);//true


        System.out.println("分割-------------------------------------------");



        Class<Animal> animalClass=Animal.class;
        System.out.println(animal instanceof Animal);//true

        System.out.println(animalClass.isInstance(animal));//true--->相当于：animal instanceof Animal

        System.out.println(animal.getClass()==Animal.class);//false





    }


}


