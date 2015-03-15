package com.recruit.base;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;

import com.recruit.base.PageBean;
import com.recruit.util.QueryHelper;

public interface DaoSupport<T> {

	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 删除实体
	 * 
	 * @param id
	 */
	void delete(Long id);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 按id查询
	 * 
	 * @param id
	 * @return
	 */
	T getById(Long id);
	T getById(Integer id);

	/**
	 * 按id查询
	 * 
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);
	List<T> getByIds(Integer[] ids);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<T> findAll();


	/**分页查找，查找本对象对应表的数据
	 * @param page  页号，从1开始
	 * @param pageSize  每页的大小
	 * @return  返回list
	 */
	public List<T> findByPage(int page, int pageSize);
	
	/**通过hql语句，查找对象
	 * @param hql  hql语句
	 * @return  返回list
	 */
	public List<T> find(String hql);
	
	/**满足特定条件的分页查找，查找本对象对应表的数据
	 * @param hql   hql语句
	 * @param page	页号，从1开始
	 * @param pageSize	每页的大小
	 * @return	返回list
	 */
	public List<T> findByPage(String hql, int page, int pageSize);
	
	/**获取表的所有数据
	 * @return  Integer，表的记录数
	 */
	public Integer getSize();
	
	/**满足特定条件的记录数量
	 * @param hql	hql语句
	 * @return	记录的数量
	 */
	public Integer getSize(String hql);
	
	/**查找有某个属性的对象
	 * @param propertyName	属性名
	 * @param value	属性值
	 * @return	对象集合list
	 */
	public List<T> findByProperty(String propertyName, Object value);
	
	/**构建查询语句
	 * @param queryString
	 * @param values
	 * @return
	 */
	public Query createQuery(String queryString, Object... values);
	
	public boolean isPropertyUnique(String propertyName, Object newValue, Object orgValue);
	
	/**根据时间区间查找
	 * @param timeBegin	开始时间
	 * @param timeEnd	结束时间
	 * @return
	 */
	public List<T> findByTime(String timeBegin, String timeEnd);
	
	public Criteria createCriteria(Criterion... criterions);
	
	public T findUniqueByProperty(String propertyName, Object value);

}
