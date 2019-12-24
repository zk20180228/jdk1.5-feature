/**
 * @Auther: zk
 * @Date: 2018/12/12 18:18
 * @Description:
 */
public class TestProcess {


    public static void main(String[] args) {


       outer: for(int i=0;i<5;i++){
         inner: for(int j=0;j<5;j++){
                if(j==3){
                    continue outer;
                }else{
                    System.out.println(i+"*"+j+"="+i*j);
                }
            }
        }


    }



}
