package cn.cmcc.enumdemo.b;


/**
 * @Auther: zk
 * @Date: 2018/12/24 10:50
 * @Description:
 */
public enum ColorEnum {

    //枚举对象，必须一次声明完
    RED("red","红色"),BLUE("blue","蓝色"),BLACK("black","黑色");

    private final String key;
    private final String value;

    //构造函数,不需要加修饰符，默认是私有的。就像接口的方法不需要加修饰符，默认是public abstract
    ColorEnum(String key,String value){
        this.key=key;
        this.value=value;
    }

    public static ColorEnum getEntityByKey(String key){

        if(null==key||key.trim().equals("")){
            return null;
        }
        ColorEnum[] colorEnums = ColorEnum.values();
        for(ColorEnum e:colorEnums){
            if(e.getKey().equals(key)){
                return e;
            }
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static void main(String[] args) {

        ColorEnum red = ColorEnum.getEntityByKey("red");
        System.out.println(red);//RED



    }



}
