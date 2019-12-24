
import java.io.*;

/**
 * @Auther: zk
 * @Date: 2018/12/17 14:22
 * @Description:  利用runtime可以执行外部程序，或者命令
 */
public class TestRuntime {

    public static Runtime runtime = Runtime.getRuntime();



    /**
     * waitFor()：导致当前线程等待，如有必要，一直要等到由该 Process 对象表示的进程已经终止。如果已终止该子进程，此方法立即返回。如果没有终止该子进程，调用的线程将被阻塞，直到退出子进程，根据惯例，0 表示正常终止

     注意：在java中，调用runtime线程执行脚本是非常消耗资源的，所以切忌不要频繁使用！

     在调用runtime去执行脚本的时候，其实就是JVM开了一个子线程去调用JVM所在系统的命令，其中开了三个通道： 输入流、输出流、错误流，其中输出流就是子线程走调用的通道。
     大家都知道，waitFor是等待子线程执行命令结束后才执行， 但是在runtime中，打开程序的命令如果不关闭，就不算子线程结束。比如以下代码。
     代码：private static Process p = null;
     p = Runtime.getRuntime().exec("notepad.exe");
     p.waitFor();
     System.out.println("--------------------------------------------我被执行了");
     以上代码中，打开windows中记事本。如果我们不手动关闭记事本，那么输出语句就不会被执行，这点是需要理解的。

     process的阻塞：
     在runtime执行大点的命令中，输入流和错误流会不断有流进入存储在JVM的缓冲区中，如果缓冲区的流不被读取被填满时，就会造成runtime的阻塞。所以在进行比如：大文件复制等的操作时，我们还需要不断的去读取JVM中的缓冲区的流，来防止Runtime的死锁阻塞。
     */

    public static void main(String[] args) {

        //testPing();
        //testPing02();
        //testProcess();
        //testProcess02();
        //testProcess03();
        //testProcess04();
        testProcess05();
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.totalMemory());

        System.out.println(System.getProperty ("os.name"));//Windows 8.1
    }


    public static  void testPing(){
        try {
            Process p = runtime.exec("ping 172.31.1.227");
            InputStream inputStream = p.getInputStream();
            byte[] bytes = new byte[1024];
            int i=0;
            while((i=inputStream.read(bytes))!=-1){
                String s = new String(bytes, 0, i,"gbk");
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void testPing02(){
        try {
            Process p = runtime.exec("java");
            InputStream inputStream = p.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"gbk");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s = bufferedReader.readLine();
            while(s!=null){
                System.out.println(s);
                s=bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void testProcess(){
        try {
            Process p = runtime.exec("javac");
            //int i = p.exitValue();//返回子进程的出口值。直接调用，会报IllegalThreadStateException，因为子进程不一定执行完毕
            int i = p.waitFor();//导致当前线程等待，如有必要，一直要等到由该 Process 对象表示的进程已经终止。
            System.out.println(i);//2
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    
    /**
     * @auther: zhangkui
     * @desc: runtime.exitValue();//返回子进程的出口值。直接调用，会报IllegalThreadStateException，
     *                              因为子进程不一定执行完毕
     *        runtime.waitFor();//导致当前线程等待，如有必要，一直要等到由该 Process 对象表示的进程已经终止。
     * @date: 2018/12/17 15:34
     * @param: 
     * @return: 
     */
    public static void testProcess02(){
        try {
            Process p = runtime.exec("java HelloWord",null,new File("E:\\test"));
            //int i = p.exitValue();//返回子进程的关闭的出口值。直接调用，会报IllegalThreadStateException，因为子进程不一定执行完毕
            InputStream errorStream = p.getErrorStream();
            InputStreamReader inputStreamReader = new InputStreamReader(errorStream,"utf-8");
            BufferedReader bf1 = new BufferedReader(inputStreamReader);
            String str1="";
            System.out.println("--------------------error--------------------------------");
            while((str1=bf1.readLine())!=null){
                System.out.println(str1);
            }
            System.out.println("--------------------error--------------------------------");

            System.out.println("--------------------right--------------------------------");
            InputStream inputStream = p.getInputStream();//获取命令执行中的打印流
            BufferedReader bf2 = new BufferedReader(new InputStreamReader(inputStream));
            String str2="";
            while((str2=bf2.readLine())!=null){
                System.out.println(str2);//
            }
            System.out.println("--------------------right--------------------------------");

            int i = p.waitFor();//导致当前线程等待，如有必要，一直要等到由该 Process 对象表示的进程已经终止。
            System.out.println(i);//2---->0代表正常结束
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    /**
     * @auther: zhangkui
     * @desc:这是一个错误案例：
     *        runtime.exitValue();//返回子进程的出口值。直接调用，会报IllegalThreadStateException，
     *                              因为子进程不一定执行完毕
     *        runtime.waitFor();//导致当前线程等待，如有必要，一直要等到由该 Process 对象表示的进程已经终止。
     *        直接执行不是当前系统的命令，如dir，就会报： java.io.IOException: CreateProcess error=2, 系统找不到指定的文件。
     *        因为dir是cmd.exe的命令，而不是系统命令.常犯的错误是把console指令或shell指令当作是系统命令
     * @date: 2018/12/17 15:34
     * @param:
     * @return:
     */
    public static void testProcess03(){
        try {
            Process p = runtime.exec("dir");
            //int i = p.exitValue();//返回子进程的出口值。直接调用，会报IllegalThreadStateException，因为子进程不一定执行完毕
            InputStream errorStream = p.getErrorStream();
            InputStreamReader inputStreamReader = new InputStreamReader(errorStream,"gbk");
            BufferedReader bf1 = new BufferedReader(inputStreamReader);
            String str1="";
            System.out.println("--------------------error--------------------------------");
            while((str1=bf1.readLine())!=null){
                System.out.println(str1);
            }
            System.out.println("--------------------error--------------------------------");

            System.out.println("--------------------right--------------------------------");
            InputStream inputStream = p.getInputStream();
            BufferedReader bf2 = new BufferedReader(new InputStreamReader(inputStream));
            String str2="";
            while((str2=bf2.readLine())!=null){
                System.out.println(str2);//
            }
            System.out.println("--------------------right--------------------------------");

            int i = p.waitFor();//导致当前线程等待，如有必要，一直要等到由该 Process 对象表示的进程已经终止。
            System.out.println(i);//2
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





    /**
     * @auther: zhangkui
     * @desc: 这是一个正确案例：执行tomcat脚本
     *        runtime.exitValue();//返回子进程的出口值。直接调用，会报IllegalThreadStateException，
     *                              因为子进程不一定执行完毕
     *        runtime.waitFor();//导致当前线程等待，如有必要，一直要等到由该 Process 对象表示的进程已经终止。
     *        直接执行不是当前系统的命令，如dir，就会报： java.io.IOException: CreateProcess error=2, 系统找不到指定的文件。
     *        因为dir是cmd.exe的命令，而不是系统命令.常犯的错误是把console指令或shell指令当作是系统命令
     * @date: 2018/12/17 15:34
     * @param:
     * @return:
     */
    public static void testProcess04(){
        try {
            Process p = runtime.exec("cmd /c startup.bat",null,new File("C:\\mySofts\\tomcat8.5\\tomcat-8.5\\bin"));
            //int i = p.exitValue();//返回子进程的出口值。直接调用，会报IllegalThreadStateException，因为子进程不一定执行完毕
            InputStream errorStream = p.getErrorStream();
            InputStreamReader inputStreamReader = new InputStreamReader(errorStream,"gbk");
            BufferedReader bf1 = new BufferedReader(inputStreamReader);
            String str1="";
            System.out.println("--------------------error--------------------------------");
            while((str1=bf1.readLine())!=null){
                System.out.println(str1);
            }
            System.out.println("--------------------error--------------------------------");

            System.out.println("--------------------right--------------------------------");
            InputStream inputStream = p.getInputStream();
            BufferedReader bf2 = new BufferedReader(new InputStreamReader(inputStream));
            String str2="";
            while((str2=bf2.readLine())!=null){
                System.out.println(str2);//
            }
            System.out.println("--------------------right--------------------------------");

            int i = p.waitFor();//导致当前线程等待，如有必要，一直要等到由该 Process 对象表示的进程已经终止。
            System.out.println(i);//2
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    /**
     * @auther: zhangkui
     * @desc: 这是一个正确案例：执行cmd命令
     *        runtime.exitValue();//返回子进程的出口值。直接调用，会报IllegalThreadStateException，
     *                              因为子进程不一定执行完毕
     *        runtime.waitFor();//导致当前线程等待，如有必要，一直要等到由该 Process 对象表示的进程已经终止。
     *        直接执行不是当前系统的命令，如dir，就会报： java.io.IOException: CreateProcess error=2, 系统找不到指定的文件。
     *        因为dir是cmd.exe的命令，而不是系统命令.常犯的错误是把console指令或shell指令当作是系统命令
     * @date: 2018/12/17 15:34
     * @param:
     * @return:
     */
    public static void testProcess05(){
        try {
            Process p = runtime.exec("cmd /c dir *.java",null,new File("E:\\test"));
            //int i = p.exitValue();//返回子进程的出口值。直接调用，会报IllegalThreadStateException，因为子进程不一定执行完毕
            InputStream errorStream = p.getErrorStream();
            InputStreamReader inputStreamReader = new InputStreamReader(errorStream,"GBK");
            BufferedReader bf1 = new BufferedReader(inputStreamReader);
            String str1="";
            System.out.println("--------------------error--------------------------------");
            while((str1=bf1.readLine())!=null){
                System.out.println(str1);
            }
            System.out.println("--------------------error--------------------------------");

            System.out.println("--------------------right--------------------------------");
            InputStream inputStream = p.getInputStream();
            BufferedReader bf2 = new BufferedReader(new InputStreamReader(inputStream));
            String str2="";
            while((str2=bf2.readLine())!=null){
                System.out.println(str2);//
            }
            System.out.println("--------------------right--------------------------------");

            int i = p.waitFor();//导致当前线程等待，如有必要，一直要等到由该 Process 对象表示的进程已经终止。
            System.out.println(i);//2
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
