package cn.cmcc.generic.demo01.a;

/**
 * @Auther: zk
 * @Date: 2018/12/21 14:33
 * @Description:
 */
public class ThreePule<A,B,C> extends TwoPule<A,B> {



    public final C three;

    public ThreePule(A a ,B b, C c){

        super(a,b);
        this.three=c;
    }


    @Override
    public String toString() {
        return super.toString()+"----------->"+this.three.toString();
    }
}
