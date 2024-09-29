package com.toLearn.sysDesign.orm_poc;

public interface IOrmUtils<T,X> {
    public  void create(Class<T>entity) throws  Exception;
    public  void updateBy(Class<T> entity)throws  Exception;
    public  T getBy(T entity)throws  Exception;
    public  void deleteBy(T entity)throws  Exception;
    public  X connection()throws  Exception;
}