package com.recruit.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.springframework.transaction.annotation.Transactional;




import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.recruit.base.PageBean;
import com.recruit.util.HibernateUtils;
import com.recruit.util.QueryHelper;

// @Transactional注解可以被继承
// @Transactional注解对父类中声明的方法无效
//@Transactional
//@SuppressWarnings("unchecked")
public  class DaoSupportImpl<T> implements DaoSupport<T> {

	//@Resource
	//private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Class<T> clazz;

	public DaoSupportImpl() {
		// 使用反射技术得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass(); // 获取当前new的对象的 泛型的父类 类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型
		
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
			return (T) getSession().get(clazz, id);
		}
	}

	public List<T> getByIds(Long[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		} else {
			return getSession().createQuery(//
					"FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)")//
					.setParameterList("ids", ids)//
					.list();
		}
	}
	
	public List<T> getByIds(Integer[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		} else {
			return getSession().createQuery(//
					"FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)")//
					.setParameterList("ids", ids)//
					.list();
		}
	}

	public List<T> findAll() {
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName())//
				.list();
	}



	@Override
	public List<T> findByPage(int page, int pageSize) {
		String hql = "from "+clazz.getSimpleName();
		int firstResult= (page-1)*pageSize;
		int lastResult= firstResult+pageSize-1;
		return session.createQuery(hql).setFirstResult(firstResult).setMaxResults(lastResult).list();

	}


	@Override
	public List<T> find(String hql) {
		// TODO Auto-generated method stub
		return session.createQuery(hql).list();
	}


	@Override
	public List<T> findByPage(String hql, int page, int pageSize) {
		// TODO Auto-generated method stub
		int firstResult= (page-1)*pageSize;
		int lastResult= firstResult+pageSize-1;
		return session.createQuery(hql).setFirstResult(firstResult).setMaxResults(lastResult).list();
	}


	@Override
	public Integer getSize() {
		Query query = session.createQuery("select count(*) from User");
		int count = ((Number)query.uniqueResult()).intValue();
		return count;
	}


	@Override
	public Integer getSize(String hql) {
		Query query = session.createQuery(hql);
		int count = ((Number)query.uniqueResult()).intValue();
		return count;
	}


	@Override
	public List<T> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return createCriteria(Restrictions.eq(propertyName, value)).list();
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
	public boolean isPropertyUnique(String propertyName, Object newValue,
			Object orgValue) {
		if (newValue == null || newValue.equals(orgValue))
            return true;
 
        Object object = findUniqueByProperty(propertyName, newValue);
        return (object == null);
	}


	@Override
	public List<T> findByTime(String timeBegin, String timeEnd) {
		String hql = "from "+clazz.getSimpleName()+" t where t.basicModel.createTime between :timeBegin and :timeEnd";
		System.out.println("hql="+hql);
		Query query = session.createQuery(hql).setString("timeBegin", timeBegin)
											  .setString("timeEnd", timeEnd);
		System.out.println("query="+query.getQueryString());
		return query.list();
	}


	@Override
	public Criteria createCriteria(Criterion... criterions) {
		Criteria criteria = session.createCriteria(clazz);
        for (Criterion c : criterions) {
            criteria.add(c);
        }
        return criteria;
	}


	@Override
	public T findUniqueByProperty(String propertyName, Object value) {
		return (T) createCriteria(Restrictions.eq(propertyName, value))
        .uniqueResult();
	}


}
