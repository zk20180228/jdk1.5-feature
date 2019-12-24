/**
 * @Auther: LENOVO
 * @Date: 2018/12/12 14:30
 * @Description:
 */
public class TestFab {


     public static void main(String args[]){
                     // F4+F3
                    //F4=F3+F2
                    //F4=F2+F1+F2=3
                    //F3=F2+F1
                     System.out.println(f(5));
                 }

     public static int f(int n){
         if(n==1||n==2){
            return 1;
         }else{
                 return f(n-1)+f(n-2);
             }
     }

}
