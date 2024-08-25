package com.hbasepoc.demo.orm_poc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class Orm implements IOrmUtils<MetaData,Connection> {
    public  void  console(){
        System.out.println("This is consoled In CallBack");
    }

    public static  void methodsConsole(Runnable method){
      method.run();
    }
    public  static  void  main(String[] args) throws Exception {
        var _orm = new Orm();
        _orm.methodsConsole(_orm::console);
        methodsConsole(() -> System.out.println("This is another callback"));
        Class<MetaData> _class =  MetaData.class;
        System.out.println(_class.getSimpleName());
        _orm.create(MetaData.class);
    }

    @Override
    public void create(Class<MetaData> entity) throws  Exception {
        StringBuilder query = new StringBuilder("INSERT INTO ");
        Connection con= connection();
        con.setAutoCommit(false);
        query.append(entity.getSimpleName().toLowerCase()).append("(");
        Field[] fields = entity.getDeclaredFields();
        for(Field _filed:fields){
            query.append(_filed.getName()).append(",");
        }
        query.deleteCharAt(query.length()-1).append(") VALUES (");
        for(Field _filed:fields){
            query.append("?,");
        }
        query.deleteCharAt(query.length() - 1);
        query.append(")");
        PreparedStatement statement = con.prepareStatement(query.toString());
        try{
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                statement.setObject(i+1,fields[i]);
            }
            statement.execute();
            con.commit();
        }catch (SQLException error){
            if(con != null){
                try {
                    con.rollback();
                }catch (SQLException err){
                    err.printStackTrace();
                }
            }
            error.printStackTrace();
        }
        finally {
            if(statement != null) statement.close();
            if(con != null) con.close();
        }
    }

    @Override
    public void update(Class<MetaData> entity) throws  Exception {

    }

    @Override
    public MetaData getBy(MetaData entity) throws  Exception {
        return null;
    }

    @Override
    public void deleteBy(MetaData entity) throws  Exception {

    }

    @Override
    public Connection connection()throws  Exception {
        return  null;
    }
}
