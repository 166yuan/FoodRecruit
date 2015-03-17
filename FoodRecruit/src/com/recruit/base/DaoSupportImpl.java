package com.recruit.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;


import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.recruit.util.HibernateUtils;


/**实现一些数据库实体的相关常用方法
 * @author 牵手无奈
 *
 * @param <T>
 */
public  abstract class DaoSupportImpl<T> implements DaoSupport<T> {


	String orderByTimeDesc ;
	String orderByTimeAsc  ;
	String from_table_t ;
	private Session session;
	private Transaction transaction;
	private Class<T> clazz;

	public DaoSupportImpl() {
		// 使用反射技术得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass(); // 获取当前new的对象的 泛型的父类 类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型
		from_table_t="from "+clazz.getSimpleName()+" t ";
		System.out.println("clazz ---> " + clazz);
	}
	
	
	public void startTransaction(){
		if(session==null||!session.isOpen()){
			session=HibernateUtils.getInstance().getSession();
		}
		
		transaction = session.beginTransaction();
	}
	
	public void commitTransaction(){
		transaction.commit();
	}




	/**
	 * 获取当前可用的Session
	 * 
	 * @return
	 */
	public Session getSession() {
		return this.session;
	}

	public void save(T entity) {
		getSession().save(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public void delete(Long id) {
		Object obj = getById(id);
		if (obj != null) {
			getSession().delete(obj);
		}
	}
    public void delete(Integer id) {
        Object obj = getById(id);
        if (obj != null) {
            getSession().delete(obj);
        }
    }
	public T getById(Long id) {
		if (id == null) {
			return null;
		} else {
			return (T) getSession().get(clazz, id);
		}
	}
	
	public T getById(Integer id) {
		if (id == null) {
			return null;
		} else {
			return (T) session.get(clazz, id);
		}
	}

	public List<T> getByIds(Long[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.emptyList();
		} else {
			String hql ="FROM " + clazz.getSimpleName() + " t WHERE id IN (:ids) ";
			return session.createQuery(hql).setParameterList("ids", ids).list();
		}
	}
	
	public List<T> getByIds(Integer[] ids) {
		return getByIds(ids);
	}

	public List<T> findAll() {
		
		return findByPage(1, 50);
	}

	


	@Override
	public List<T> findByPage(int page, int pageSize) {
		return findByHql(from_table_t, page, pageSize);

	}
	
	@Override
	public List<T> findByPage(int page, int pageSize, String property,
			boolean isAsc) {

		return findByHql(from_table_t, page, pageSize,property,isAsc);
	}


	@Override
	public List<T> findByHql(String hql,int page, int pageSize) {
		int firstResult= (page-1)*pageSize;
		int lastResult= firstResult+pageSize;
		Query query = session.createQuery(hql).setFirstResult(firstResult).setMaxResults(lastResult);
		System.out.println("query="+query.toString());
		return query.list();
	}

	@Override
	public List<T> findByHql(String hql, int page, int pageSize,
			String property, boolean isAsc) {
		String asc_desc = " desc ";
		if(isAsc) asc_desc =" asc ";
		hql = hql+" order by t."+property+asc_desc;
		return findByHql(hql, page, pageSize);
	}

	@Override
	public Integer getSize() {
		return getSize(from_table_t);
	}


	@Override
	public Integer getSize(String hql) {
		hql ="select count(*) "+ hql;
		Query query = session.createQuery(hql);
		int count = ((Number)query.uniqueResult()).intValue();
		return count;
	}


//	@Override
//	public List<T> findByProperty(String propertyName, Object value) {
//		// TODO Auto-generated method stub
//		return createCriteria(Restrictions.eq(propertyName, value)).list();
//	}
	
	@Override
	public List<T> findByProperty(String property, Object value, int page,
			int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(property, value);
		return findByProperties(map, page, pageSize);
	}


	@Override
	public List<T> findByProperty(String myProperty, Object value, int page,
			int pageSize, String property, boolean isAsc) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(myProperty, value);
		return findByProperties(map, page, pageSize, property, isAsc);
	}
	
	@Override
	public List<T> findByProperties(T entity,int page , int pageSize) {
        if(page<1){
            page=1;
        }
		int firstResult= (page-1)*pageSize;
		int lastResult=pageSize;
		
		return session.createCriteria(clazz).add(Example.create(entity))
				.setFirstResult(firstResult).setMaxResults(lastResult).list();
	}
	
	@Override
	public List<T> findByProperties(Map<String, Object> map,int page , int pageSize,
			String property, boolean isAsc) {
		
		String hql = createFindByPropertiesHql(map);
		return findByHql(hql, page, pageSize, property, isAsc);
	}
	

	@Override
	public List<T> findByProperties(Map<String, Object> map, int page,
			int pageSize) {
		String hql = createFindByPropertiesHql(map);
		return findByHql(hql, page, pageSize);
	}
	
	@Override
	public Integer getFindByPropertiesSize(Map<String, Object> map) {
		String hql = createFindByPropertiesHql(map);
		return getSize(hql);
	}


	@Override
	public String createFindByPropertiesHql(Map<String, Object> map) {

		StringBuffer stringBuffer = new StringBuffer(from_table_t);
		stringBuffer.append(" where ");
		int size = map.size();
		int i=1;
		for(String key:map.keySet()){
			Object value = map.get(key);
			if(value.getClass().getSimpleName().equals("String")){
				stringBuffer.append(" t."+key + " = '"+value+"' ");
			}else {
				stringBuffer.append(" t."+key + " = "+value+" ");
			}
				
			if(i<size){
				stringBuffer.append(" and ");
			}
			i++;
		}
		
		System.out.println(stringBuffer.toString());
		
		return stringBuffer.toString();
		
	}

	@Override
	public Query createQuery(String queryString, Object... values) {
		session.createQuery(queryString);
        Query queryObject = session.createQuery(queryString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                queryObject.setParameter(i, values[i]);
            }
        }
        return queryObject;
	}
	
	




	@Override
	public List<T> findByTime(String timeBegin, String timeEnd,int page , int pageSize) {
		String hql = createFindByTimeHql(timeBegin, timeEnd);
		return findByHql(hql, page, pageSize);
	}



	@Override
	public List<T> findByTime(String timeBegin, String timeEnd,int page , int pageSize,
			String property, boolean isAsc) {
		
		String hql = createFindByTimeHql(timeBegin, timeEnd);
		return findByHql(hql, page, pageSize, property, isAsc);
	}


	


	@Override
	public Integer getFindByTimeSize(String timeBegin, String timeEnd) {
		String hql = createFindByTimeHql(timeBegin, timeEnd);
		return getSize(hql);
	}


	@Override
	public String createFindByTimeHql(String timeBegin, String timeEnd) {
		String hql = from_table_t+" where t.createTime between :timeBegin and :timeEnd";
		Query query = session.createQuery(hql).setString("timeBegin", timeBegin)
											  .setString("timeEnd", timeEnd);
		hql = query.getQueryString();
		return hql;
	}


	




	
	



//	@Override
//	public Criteria createCriteria(Criterion... criterions) {
//		Criteria criteria = session.createCriteria(clazz);
//        for (Criterion c : criterions) {
//            criteria.add(c);
//        }
//        return criteria;
//	}


//	@Override
//	public T findUniqueByProperty(String propertyName, Object value) {
//		return (T) createCriteria(Restrictions.eq(propertyName, value))
//        .uniqueResult();
//	}
	



}
