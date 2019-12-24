package cn.cmcc.annotation.e;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zk
 * @Date: 2018/12/25 16:46
 * @Description: 运行时注解处理器，用来构建建表语句
 */
public class TableCreator {

    public static String getCreateTableSql(String className) throws ClassNotFoundException {

        Class<?> clazz = Class.forName(className);
        DBTable dbTable = clazz.getAnnotation(DBTable.class);
        if(dbTable==null){
            System.out.println("No DBTable annotations in class"+className);
            return null;
        }

        //表名
        String tableName=dbTable.name();

        //如果表名为空，取类的简单名
        if(tableName==null||tableName.trim().length()<1)
            tableName=clazz.getSimpleName().toUpperCase();

        List<String> columnDefs = new ArrayList<>();

        Field[] fields = clazz.getDeclaredFields();

        for(Field f: fields){

            //获取 字段上的注解
            Annotation[] fieldAns = f.getDeclaredAnnotations();
            if(fieldAns==null||fieldAns.length==0)
                continue;
            Annotation used= fieldAns[0];

            //AGE INT NOT NULL,
            if(used instanceof SQLInteger){

                SQLInteger sqlInteger= (SQLInteger) used;
                String integerColumn =sqlInteger.name();
                if(integerColumn==null||integerColumn.trim().length()==0)
                    integerColumn=f.getName().toUpperCase();//如果列名为空，取字段名
                //获取字段约束
                Constraints integerConstraint = sqlInteger.constraint();
                columnDefs.add(integerColumn+" INT"+getConstraints(integerConstraint));
                continue;
            }

            //ID VARCHAR(50) NOT NULL PRIMARY KEY,
            if(used instanceof SQLString){

                SQLString sqlString= (SQLString) used;

                String stringColumn = sqlString.name();
                if(stringColumn==null||stringColumn.trim().length()==0)
                    stringColumn=f.getName().toUpperCase();
                int columnLength = sqlString.value();
                //获取字段约束
                Constraints integerConstraint = sqlString.constraint();
                columnDefs.add(stringColumn+" VARCHAR("+columnLength+")"+getConstraints(integerConstraint));
            }
        }

        StringBuffer sb = new StringBuffer();

        sb.append(" CREATE TABLE "+tableName+"(");
        for(String column:columnDefs){
            sb.append(column+",");
        }

        return  sb.substring(0,sb.length()-1)+");";
    }




    public static String  getConstraints(Constraints constraint){

        StringBuffer sb=new StringBuffer("");

        if(constraint==null){
            return sb.toString();
        }
        if(!constraint.allowNull())
            sb.append(" NOT NULL");
        if(constraint.primarykey())
            sb.append(" PRIMARY KEY");
        if(constraint.unique())
            sb.append(" UNIQUE");

        return sb.toString();
    }


    public static void main(String[] args) {
        try {
            String createTableSql = getCreateTableSql("cn.cmcc.annotation.e.Member");
            System.out.println(createTableSql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
