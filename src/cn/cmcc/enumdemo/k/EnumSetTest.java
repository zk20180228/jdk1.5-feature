package cn.cmcc.enumdemo.k;

import java.util.EnumSet;

/**
 * @Auther: zk
 * @Date: 2018/12/24 18:44
 * @Description:
 */
public class EnumSetTest {

    public static void main(String[] args) {

        EnumSet<PhoneEnum> phoneEnumEnumSet01 = EnumSet.noneOf(PhoneEnum.class);

       //phoneEnumEnumSet01.add(PhoneEnum.APPLE);

        System.out.println(phoneEnumEnumSet01);//[]


        EnumSet<PhoneEnum> phoneEnumEnumSet02 = EnumSet.allOf(PhoneEnum.class);

        System.out.println(phoneEnumEnumSet02);//[APPLE, HUAWEI, ZHONGXING, XIOMI]
    }


}
