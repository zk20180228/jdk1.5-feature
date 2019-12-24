/**
 * @Auther: LENOVO
 * @Date: 2018/12/12 16:52
 * @Description:
 */
public class TestNumber {


    public static void main(String[] args) {

        long a=111111111l;
        float b=a;
        System.out.println(b);

        String c=57.0f+"";
        System.out.println(c);//57.0
        String d=57f+"";
        System.out.println(d);//57.0
        System.out.println(57.0f==57f);//true

        int rs=0;
        for(int i=0;i<=100;i++){
            rs+=i;
        }
        System.out.println(rs);

    }
}
