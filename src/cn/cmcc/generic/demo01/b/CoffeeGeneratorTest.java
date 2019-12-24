package cn.cmcc.generic.demo01.b;

/**
 * @Auther: zk
 * @Date: 2018/12/21 15:11
 * @Description:
 */
public class CoffeeGeneratorTest {


    public static void main(String[] args) {
        CoffeeGenerator coffeeGenerator = new CoffeeGenerator();
        Coffee coffee = coffeeGenerator.next();
        System.out.println(coffee);
    }
}
