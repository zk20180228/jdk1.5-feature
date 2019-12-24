package cn.cmcc.generic.demo01.a;

/**
 * @Auther: zk
 * @Date: 2018/12/21 14:18
 * @Description:
 */
public class TwoPule<A,B> {

    //final声明的成员变量必须初始化，直接初始化或者构造函数中初始化
    public final A first;
    public final B second;

    public TwoPule(A a,B b){
        this.first=a;
        this.second=b;
    }


    @Override
    public String toString(){

        return first.toString()+"-------->"+second.toString();
    }





}
