/*package com.pro.xwt.common.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.pro.xwt.common.utils.ReflectionUtil;

public class AbstractBaseMapper <T, ID extends Serializable> implements  
BaseMapper<T, ID> {

    @Autowired  
    private SqlSessionFactory sqlSessionFactory;  
  
    private Class<?> entityMapperClass;  
  
    protected BaseMapper<T, ID> getBaseMapper() {  
        SqlSession session = sqlSessionFactory.openSession();  
        entityMapperClass = ReflectionUtil.getMatcherMapper(getClass());  
        @SuppressWarnings("unchecked")  
        BaseMapper<T, ID> baseMapper = (BaseMapper<T, ID>) session  
                .getMapper(entityMapperClass);  
        return baseMapper;  
    }  
  
    public SqlSessionFactory getSqlSessionFactory() {  
        return sqlSessionFactory;  
    }  
  
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {  
        this.sqlSessionFactory = sqlSessionFactory;  
    }  
	@Override
	public int insert(T t) {
		
		return getBaseMapper().insert(t);
	}

	@Override
	public int insertBatch(List<T> t) {
		
		return getBaseMapper().insertBatch(t);
	}

	@Override
	public int deleteBatchById(List<ID> ids) {
		
		return getBaseMapper().deleteBatchById(ids);
	}

	@Override
	public int deleteById(ID id) {
		
		return getBaseMapper().deleteById(id);
	}

	@Override
	public int deleteById(String id) {
		
		return getBaseMapper().deleteById(id);
	}

	@Override
	public int update(T t) {
		
		return getBaseMapper().update(t);
	}

	@Override
	public T find(Map<String, Object> parameter) {
		
		return getBaseMapper().find(parameter);
	}

	@Override
	public T findById(ID id) {
		
		return getBaseMapper().findById(id);
	}

	@Override
	public T findById(String id) {
		
		return getBaseMapper().findById(id);
	}

	@Override
	public T findByName(String name) {
		
		return getBaseMapper().findByName(name);
	}

	@Override
	public List<T> queryListAll(Map<String, Object> parameter) {
		
		return getBaseMapper().queryListAll(parameter);
	}

	@Override
	public List<T> queryListByPage(Map<String, Object> parameter) {
		
		return getBaseMapper().queryListByPage(parameter);
	}

	@Override
	public int count(Map<String, Object> parameter) {
		
		return getBaseMapper().count(parameter);
	}

	@Override
	public T findByCondition(Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> queryListByPojo(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
*/