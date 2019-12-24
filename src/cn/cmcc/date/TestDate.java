package cn.cmcc.date;

import java.util.Date;

/**
 * @Auther: zk
 * @Date: 2018/12/19 18:20
 * @Description: Date
 */
public class TestDate {


    public static void main(String[] args) throws InterruptedException {
        Date date1 = new Date();
        Thread.sleep(100);
        Date date2 = new Date();

        boolean isBefore = date1.before(date2);
        System.out.println(isBefore);//true
        boolean isafter = date2.after(date1);
        System.out.println(isafter);//true
        Thread.sleep(100);
        long l = System.currentTimeMillis();
        date2.setTime(l);
        System.out.println(l==date2.getTime());//true
        Date date = new Date(l);

        //当且仅当 getTime 方法对于两个 Date 对象返回相同的 long 值时,返回true
        System.out.println(date.equals(date2));//true
    }


}
