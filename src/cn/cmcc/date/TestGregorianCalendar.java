package cn.cmcc.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: zk
 * @Date: 2018/12/20 10:02
 * @Description: Calendar
 */
public class TestGregorianCalendar {

    public static void main(String[] args) {
        //  使用默认时区和语言环境获得一个日历,默认值是当前时间
        Calendar calendar01 = Calendar.getInstance();
        // 获取，即格林威治标准时间 1970 年 1 月 1 日的 00:00:00.000，格里高利历到当前的的偏移量，即当前时间
        Date date01 = calendar01.getTime();
        System.out.println(date01.getTime());
        Date date02 = new Date();
        System.out.println(date02.getTime());
        System.out.println(date01.equals(date02));//false date02 要比date01晚十几毫秒

        //Calendar.MONTH字段代表月份，月份的起始值不是1，而是0。国外:星期天（Sunday,中国的周日）算为每周的第一天 。 当前时间2018-12-20 10 周四
        System.out.println(calendar01.get(Calendar.YEAR));//2018
        System.out.println(calendar01.get(Calendar.MONTH)+1);//12 月份的起始值不是1，而是0
        System.out.println(calendar01.get(Calendar.DAY_OF_MONTH));//20
        System.out.println(calendar01.get(Calendar.DAY_OF_WEEK));//5 国外:星期天（Sunday,中国的周日）算为每周的第一天，所以一周的第五天应该为周四
        System.out.println(calendar01.get(Calendar.DAY_OF_YEAR));//一天中的第354天
        System.out.println(calendar01.get(Calendar.WEEK_OF_MONTH ));//一月中的第几4周
        System.out.println(calendar01.get(Calendar.HOUR_OF_DAY));//10     24小时制


        Calendar calendar02 = Calendar.getInstance();
        System.out.println(calendar02.getTime().getTime());//1545273626623
        //设置时间为：2003-11-23  12:32:23
        calendar02.set(2003,10,23,12,32,23);
        //yyyy-MM-dd HH:mm:ss
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date03 = simpleDateFormat.parse("2003-11-23 12:32:23");//1069561943000 不会设置毫秒值位置，末尾三位是000
            System.out.println(simpleDateFormat.format(date03));
            System.out.println(simpleDateFormat.format(calendar02.getTime()));
            System.out.println(date03.getTime());//1069561943000
            System.out.println(calendar02.getTime().getTime());//1069561943623
            System.out.println(date03.equals(calendar02.getTime()));//fasle  注意，由于刚生成的calendar,默认值是当前时间，因此，没有设置毫秒位置，只设置了日月年时分秒，但是毫秒值位置是有值的

            calendar02.set(Calendar.MILLISECOND,0);
            System.out.println(calendar02.getTime().getTime());//1069561943000
            System.out.println(date03.equals(calendar02.getTime()));//true  吧毫秒位置设置为0 ，二者就相等了

            Date date = new Date(1545273626623l);
            System.out.println(simpleDateFormat.format(date));//2018-12-20 10:40:26


            //add 非常强大,动态的让时间改变，可以解决自动进位问题
            calendar02.add(Calendar.YEAR,1);//家一年
            System.out.println(simpleDateFormat.format(calendar02.getTime()));//2004-11-23 12:32:23

            //Calendar的宽松模式：默认是宽松模式
            Calendar calendar03 = Calendar.getInstance();
            calendar03.set(Calendar.MONTH,13);//会自动在当前月份add2个月
            System.out.println(simpleDateFormat.format(calendar03.getTime()));//2019-02-20 11:00:53

            //非宽松模式
            Calendar calendar04 = Calendar.getInstance();

            //calendar04.setLenient();
            //此时不报错：set()方法的延迟修改。虽然日历字段是立即更改的，但Calendar所代表的时间却不会立即修改，直到下次调用get()、getTime()、getTimeInMillis()、add()或roll()时才会重新计算日历的时间。这被称为set()方法的延迟修改
            calendar04.set(Calendar.MONTH,100);
            System.out.println(simpleDateFormat.format(calendar04.getTime()));//抛异常:java.lang.IllegalArgumentException: MONTH

            // AD:公元
            SimpleDateFormat sdf = new SimpleDateFormat("Gyyyy年中第D天");
            Date date05 = new Date();
            String date05f = sdf.format(date05);
            System.out.println(date05f);//公元2018年中第354天

            //一个非常特殊的日期字符串
            String str = "2016###08##10";
            SimpleDateFormat sm = new SimpleDateFormat("yyyy###MM##d");
            Date dt = sm.parse(str);
            System.out.println(dt);//Wed Aug 10 00:00:00 CST 2016


            //java8新特性:LocalDate,LocalTime,LocalDateTime,FormatStyle,DateTimeFormatter
            //ISO:国际标准化组织
            LocalDateTime nowDate = LocalDateTime.now();
            DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;//国际化标准日期
            System.out.println(isoDate.format(nowDate));//2018-12-20

            DateTimeFormatter isoTime = DateTimeFormatter.ISO_TIME;//国际化标准时间
            System.out.println(isoTime.format(nowDate));//14:16:05.132

            DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;//国际化标准日期时间
            System.out.println(isoDateTime.format(nowDate));//2018-12-20T14:16:05.132

            DateTimeFormatter dateTimeFormatterFull = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
            System.out.println(dateTimeFormatterFull.format(nowDate));//2018年12月20日 星期四

            DateTimeFormatter dateTimeFormatterLong = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
            System.out.println(dateTimeFormatterLong.format(nowDate));//2018年12月20日

            DateTimeFormatter dateTimeFormatterMedium = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
            System.out.println(dateTimeFormatterMedium.format(nowDate));//2018-12-20

            DateTimeFormatter dateTimeFormatterShort = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
            System.out.println(dateTimeFormatterShort.format(nowDate));//18-12-20

            //接下来的这几个，正好是我们经常使用的
            DateTimeFormatter dateTimeFormatterFF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM);
            System.out.println(dateTimeFormatterFF.format(nowDate));//2018-12-20 14:28:05

            DateTimeFormatter dateTimeFormatterPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.println(dateTimeFormatterPattern.format(nowDate));//2018-12-20 14:28:05

            String strDate = nowDate.format(dateTimeFormatterPattern);//2018-12-20 14:28:05
            System.out.println(strDate);

            String st ="2018-12-20 14:31:21";

            LocalDateTime parseDate01 = LocalDateTime.parse(st, dateTimeFormatterPattern);//这个要好用点

            TemporalAccessor parseTA = dateTimeFormatterPattern.parse(st);
            System.out.println(parseDate01);//2018-12-20T14:31:21
            System.out.println(parseTA);//{},ISO resolved to 2018-12-20T14:31:21
            System.out.println(dateTimeFormatterPattern.format(parseTA));//2018-12-20 14:31:21

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
