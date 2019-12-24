package cn.cmcc.date;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @Auther: zk
 * @Date: 2018/12/20 16:57
 * @Description:
 */
public class TestLocalDateTime {


    public static void main(String[] args) {

        LocalDateTime nowDate = LocalDateTime.now();
        System.out.println(nowDate);//2018-12-20T16:57:55.522

        //获取毫秒数//1545296658186
        System.out.println(nowDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());


    }
}
