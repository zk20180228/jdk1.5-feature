package cn.cmcc.enumdemo.k;

import java.util.*;

/**
 * @Auther: zk
 * @Date: 2018/12/24 18:44
 * @Description:
 */
public class EnumMapTest {



    public static void main(String[] args) {
        List<PhoneFactory> list = new ArrayList<>();
        list.add(new PhoneFactory(PhoneEnum.APPLE, 100));
        list.add(new PhoneFactory(PhoneEnum.ZHONGXING, 2000));
        list.add(new PhoneFactory(PhoneEnum.HUAWEI, 1800));
        list.add(new PhoneFactory(PhoneEnum.XIOMI, 1200));

        list.add(new PhoneFactory(PhoneEnum.APPLE, 3000));
        list.add(new PhoneFactory(PhoneEnum.ZHONGXING, 800));
        list.add(new PhoneFactory(PhoneEnum.HUAWEI, 5000));
        list.add(new PhoneFactory(PhoneEnum.XIOMI, 300));

        list.add(new PhoneFactory(PhoneEnum.APPLE, 3000));
        list.add(new PhoneFactory(PhoneEnum.ZHONGXING, 2400));
        list.add(new PhoneFactory(PhoneEnum.HUAWEI, 1800));
        list.add(new PhoneFactory(PhoneEnum.XIOMI, 3700));

        //统计方式一：
        Map<PhoneEnum, Integer> map = new HashMap<>();
        for(PhoneFactory pf:list){
            PhoneEnum phoneEnum = pf.getPhoneEnum();
            Integer count = map.get(phoneEnum);
            if(count!=null){
                map.put(phoneEnum,count+pf.getNum());
            }else{
                map.put(phoneEnum,pf.getNum());
            }
        }

        Set<Map.Entry<PhoneEnum, Integer>> entries01 = map.entrySet();
        for(Map.Entry et:entries01){
            System.out.println(et.getKey()+"----->"+et.getValue());
        }

        //统计方式二：方式二高效，而且可以保证顺序和枚举声明的顺序一致
        EnumMap<PhoneEnum, Integer> enumMap = new EnumMap<>(PhoneEnum.class);
        for(PhoneFactory pf:list){
            PhoneEnum phoneEnum = pf.getPhoneEnum();
            Integer count = enumMap.get(phoneEnum);
            if(count!=null){
                enumMap.put(phoneEnum,count+pf.getNum());
            }else{
                enumMap.put(phoneEnum,pf.getNum());
            }
        }

        Set<Map.Entry<PhoneEnum, Integer>> enumMaps = enumMap.entrySet();
        for(Map.Entry et:enumMaps){
            System.out.println(et.getKey()+"----->"+et.getValue());
        }
    }



}
