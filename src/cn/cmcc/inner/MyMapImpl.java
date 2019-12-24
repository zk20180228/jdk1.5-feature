package cn.cmcc.inner;

/**
 * @Auther: LENOVO
 * @Date: 2018/12/19 17:32
 * @Description:
 */
public class MyMapImpl implements MyMap {



    @Override
    public boolean put(String key, String value) {
        return false;
    }

    class MyEntryImpl implements MyEntry{


        @Override
        public void print() {
            System.out.println("内部接口。。。。。。。。。。。。"+M_D);
        }
    }


    public static void main(String[] args) {

        MyMap.MyEntry myEntry = new MyMapImpl().new MyEntryImpl();

        myEntry.print();

    }



}
