package cn.cmcc.enumdemo.k;

/**
 * @Auther: zk
 * @Date: 2018/12/24 18:13
 * @Description:
 */
public class PhoneFactory {

    private PhoneEnum phoneEnum;
    private Integer num;

    public PhoneFactory(){

    }

    public PhoneFactory(PhoneEnum phoneEnum, Integer num) {
        this.phoneEnum = phoneEnum;
        this.num = num;
    }


    public PhoneEnum getPhoneEnum() {
        return phoneEnum;
    }

    public void setPhoneEnum(PhoneEnum phoneEnum) {
        this.phoneEnum = phoneEnum;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
