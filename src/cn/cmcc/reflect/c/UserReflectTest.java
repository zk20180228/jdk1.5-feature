package cn.cmcc.reflect.c;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * @Auther: zk
 * @Date: 2018/12/26 16:15
 * @Description:
 *
 * 其中关于Type类型这里简单说明一下，Type 是 Java 编程语言中所有类型的公共高级接口。它
 * 们包括原始类型、参数化类型、数组类型、类型变量和基本类型。getGenericParameterTypes 与 getParameterTypes
 * 都是获取构成函数的参数类型，前者返回的是Type类型，后者返回的是Class类型，由于Type顶级接口，Class也实现了该接口，
 * 因此Class类是Type的子类，Type 表示的全部类型而每个Class对象表示一个具体类型的实例，如String.class仅代表String类型。
 * 由此看来Type与 Class 表示类型几乎是相同的，只不过 Type表示的范围比Class要广得多而已。当然Type还有其他子类，如：
 *
 *  TypeVariable：表示类型参数，可以有上界，比如：T extends Number
 *
 *  ParameterizedType：表示参数化的类型，有原始类型和具体的类型参数，比如：List<String>
 *
 *  WildcardType：表示通配符类型，比如：?, ? extends Number, ? super Integer
 *
 *
 *
 */
public class UserReflectTest {


    public static void main(String[] args) throws Exception {



        Class<User> userClass = (Class<User>) Class.forName("cn.cmcc.reflect.c.User");

        //T
        //java.lang.String
        //java.lang.String
        //int
        //java.util.Date
        //java.lang.String
        //java.lang.Class<java.lang.String>
        //int[]
        Field[] declaredFields1 = userClass.getDeclaredFields();
        for(Field f:declaredFields1){
            System.out.println(f.getGenericType().getTypeName());
        }


        //利用无参构造函数创建对象
        User user01 = userClass.newInstance();
        user01.setAge(28);
        user01.setBrithday(new Date());
        user01.setId(UUID.randomUUID().toString().replace("-",""));
        user01.setName("张三");
        user01.setUserType("1");
        //User{id='f4ed8aba7ac84dfcaa3cec20b086aca7', name='张三', age=28, brithday=Wed Dec 26 16:22:04 CST 2018, userType='1'}
        System.out.println(user01);


        Constructor<User> noParamterConstructor = userClass.getConstructor();
        User user02 = noParamterConstructor.newInstance();
        user02.setAge(28);
        user02.setBrithday(new Date());
        user02.setId(UUID.randomUUID().toString().replace("-",""));
        user02.setName("里斯");
        user02.setUserType("2");
        //User{id='b4daeec56e0c4a749378f9989dbdf63f', name='里斯', age=28, brithday=Wed Dec 26 16:30:05 CST 2018, userType='2'}
        System.out.println(user02);


        Constructor<User> thirdParamterConstructor = userClass.getDeclaredConstructor(String.class, int.class, Date.class);
        //设置暴力访问
        thirdParamterConstructor.setAccessible(true);
        User user03 = thirdParamterConstructor.newInstance("王五",26,new Date());
        //User{id='null', name='王五', age=26, brithday=Wed Dec 26 16:37:43 CST 2018, userType='null'}
        System.out.println(user03);

        Constructor<?>[] declaredConstructors = userClass.getDeclaredConstructors();


        /**
         * cn.cmcc.reflect.c.User[class java.lang.String, class java.lang.String, int, class java.util.Date, class java.lang.String]
           cn.cmcc.reflect.c.User[class java.lang.String, int, class java.util.Date]
           cn.cmcc.reflect.c.User[]
         */
        for(Constructor c:declaredConstructors){
            ////泛型在反射的时候是Object类型
            System.out.println(c.getName()+Arrays.toString(c.getParameterTypes()));
        }

        //获取创建此构造器的Class对象
        Class<User> declaringClass = thirdParamterConstructor.getDeclaringClass();
        System.out.println(declaringClass==userClass);//true


        //泛型在反射的时候是Object类型
        Constructor<User> fourParamterConstructor = userClass.getConstructor(String.class, int.class, Date.class,Object.class,Class.class);
        //获取 带泛型的构造方法的参数类型
        Type[] genericParameterTypes = fourParamterConstructor.getGenericParameterTypes();
        //[class java.lang.String, int, class java.util.Date, T]--->名字也可以反射出来T
        System.out.println(Arrays.toString(genericParameterTypes));
        // 获取构造方法的参数类型，返回字节数组
        //[class java.lang.String, int, class java.util.Date, class java.lang.Object]
        System.out.println(Arrays.toString(fourParamterConstructor.getParameterTypes()));

        //获取Constructor的字符串描述形式，包括参数类型
        //public cn.cmcc.reflect.c.User(java.lang.String,int,java.util.Date,T)
        System.out.println(fourParamterConstructor.toGenericString());

        //返回Constructor的名字 包名.方法名
        //cn.cmcc.reflect.c.User
        System.out.println(fourParamterConstructor.getName());

        //返回此构造器参数的个数
        System.out.println(fourParamterConstructor.getParameterCount());//4

        //返回[]
        System.out.println(Arrays.toString(fourParamterConstructor.getTypeParameters()));//[]

        //仅当此可执行文件是由The Java™ Language Specification定义的 合成结构，则为true 。
        //从以下版本开始：
        //1.5
        System.out.println(fourParamterConstructor.isSynthetic());//false

        //是否是可变参数
        System.out.println(fourParamterConstructor.isVarArgs());//false

        //判断该构造函数是否有指定类型的注解
        //System.out.println(fourParamterConstructor.isAnnotationPresent(xx.class));

        //判断是否是不可访问的(私有的)
        System.out.println(fourParamterConstructor.isAccessible());//false

        for(Type type:genericParameterTypes){
           // Class clazz= (Class) type;//会报类型转换异常  T  sun.reflect.generics.reflectiveObjects.TypeVariableImpl cannot be cast to java.lang.Class
            System.out.println(type.getTypeName());
        }

        System.out.println("---------------------------------------分割线-----------------------------------");
        //获取所有public 的字段，包括继承
        Field[] fields = userClass.getFields();
        for(Field f:fields){
            f.setAccessible(true);
            String name = f.getName();
            System.out.println(name);
        }

        System.out.println("===============================================================================");
        //获取所有字段(包含私有)，但不包含继承的字段
        Field[] declaredFields = userClass.getDeclaredFields();
        for(Field f:declaredFields){
            f.setAccessible(true);
            //f.setxx(xx,xx)
            //f.get(obj) 获取指定对象在此字段上的值
            String name = f.getName();
            System.out.println(name);
        }



        System.out.println("---------------------------------------------------METHOD-----------------------------------------------------");


        Method[] declaredMethods = userClass.getDeclaredMethods();
        for(Method m:declaredMethods){
            m.setAccessible(true);
            System.out.println(m.getName());
        }

        System.out.println("==========###########++++++++++++++++++++++++++++++++++++++++++++++");
        Method[] methods = userClass.getMethods();
        for(Method m:methods){
            System.out.println(m.getName());
            //返回该方法在指定对象上的执行结果
            //public Object invoke(Object obj, Object... args)
            //返回该方法执行后的结果类型
            //public Class<?> getReturnType()
        }

        //根据名称和参数,获取指定类型的方法
       // public Method getMethod(String name, Class<?>... parameterTypes)



    }



}
