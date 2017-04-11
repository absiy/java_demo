package com.pro.xwt.common.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseService<T,ID extends Serializable> {

    public int insert(T t);
    
    public int deleteById(ID id);
 
    public int update(T t);
    
    public T findByCondition(Map<String, Object> parameter);
 
    public T findById(ID id);
 
    public List<T> queryListAll(Map<String, Object> parameter);
    
    public List<T> queryListByPojo(T t);
    
    int count(Map<String, Object> parameter);

    /* public int deleteById(String id);*/

    /*  public T findById(String id);*/
    
    /* public int insertBatch(List<T> t);*/
    
    /* public int deleteBatchById(List<ID> ids);*/
    
    /* public T findByName(String name);*/
}
