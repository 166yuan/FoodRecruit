package com.recruit.base;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;


/**定义数据库实体的一些常用方法
 * @author 牵手无奈
 *
 * @param <T>
 */
public interface DaoSupport<T> {

	/**保存实体
	 * @param entity
	 */
	void save(T entity);

	/**删除实体
	 * @param id
	 */
	void delete(Long id);
    void delete(Integer id);
	/** 更新实体
	 * @param entity
	 */
	void update(T entity);

	/**按id查询
	 * @param id
	 * @return
	 */
	T getById(Long id);
	T getById(Integer id);

	/**按id查询
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);
	List<T> getByIds(Integer[] ids);

	/**
	 * 这个方法并不是查询所有，只查询50个,因为避免返回太多结果
	 * @return
	 */
	List<T> findAll();

	
	/**分页查找，查找本对象对应表的数据,并指定以那个属性排序和排序规则
	 * @param page
	 * @param pageSize
	 * @param property  准备以那个属性来排序
	 * @param isAsc		是否是升序
	 * @return
	 */
	public List<T> findByPage(int page, int pageSize, String property, boolean isAsc);
	
	
	/**分页查找，查找本对象对应表的数据
	 * @param page  页号，从1开始
	 * @param pageSize  每页的大小
	 * @return  返回list
	 */
	public List<T> findByPage(int page, int pageSize);
	
	
	
	
	
	/**通过hql语句，查找对象，做分页查询
	 * @param hql	查询语句
	 * @param page	页码
	 * @param pageSize	页大小
	 * @return
	 */
	public List<T> findByHql(String hql, int page, int pageSize);
	
	/**通过hql语句，查找对象，做分页查询，并指定以那个属性排序和排序规则
	 * @param hql	查询语句
	 * @param page	页码
	 * @param pageSize	页大小
	 * @param property	要排序的属性
	 * @param isAsc		true为升序，false为降序
	 * @return
	 */
	public List<T> findByHql(String hql, int page, int pageSize, String property, boolean isAsc);
	
	/**获取表的所有数据的数量
	 * @return  Integer，表的记录数
	 */
	public Integer getSize();
	
	/**满足特定条件的记录数量
	 * @param hql	hql语句
	 * @return	记录的数量
	 */
	public Integer getSize(String hql);
	

	
	/**查找有多个属性值的对象
	 * @param hashMap 属性名与属性值的键值对
	 * @return 对象集合list
	 */
	public List<T> findByProperties(T entity, int page, int pageSize);
	
	/**获取指定属性条件下的记录数量,,map的值只能是数值或者string对象，其它对象都不能放进来
	 * @param map	属性名和属性值
	 * @return	数量int
	 */
	public Integer getFindByPropertiesSize(Map<String, Object> map);
	
	/**构建相关hql语句
	 * @param map	属性名和属性值
	 * @return
	 */
	public String createFindByPropertiesHql(Map<String, Object> map);
	
	/**查找有多个属性值的对象,map的值只能是数值或者string对象，其它对象都不能放进来
	 * @param hashMap 属性名与属性值的键值对
	 * @param page	页码
	 * @param pageSize	页大小
	 * @param property  准备以那个属性来排序
	 * @param isAsc		是否是升序
	 * @return
	 */
	public List<T> findByProperties(Map<String, Object> map, int page, int pageSize, String property, boolean isAsc);
	
	
	/**对单一属性查询,value的值只能是数值或者string对象，其它对象都不能放进来
	 * @param property	属性名
	 * @param value		属性值
	 * @param page	页码
	 * @param pageSize	页大小
	 * @return
	 */
	public List<T> findByProperty(String property, Object value, int page, int pageSize);
	
	/**对单一属性查询,并做排序,value的值只能是数值或者string对象，其它对象都不能放进来
	 * @param property	属性名
	 * @param value		属性值
	 * @param page	页码
	 * @param pageSize	页大小
	 * @param property  准备以那个属性来排序
	 * @param isAsc		是否是升序
	 * @return
	 */
	public List<T> findByProperty(String myProperty, Object value, int page, int pageSize, String property, boolean isAsc);
	
	/**查找有多个属性值的对象
	 * @param hashMap 属性名与属性值的键值对
	 * @param page	页码
	 * @param pageSize	页大小
	 * @return
	 */
	public List<T> findByProperties(Map<String, Object> map, int page, int pageSize);
	
	/**构建查询语句
	 * @param queryString
	 * @param values
	 * @return
	 */
	public Query createQuery(String queryString, Object... values);
	
	
	/**根据时间区间查找
	 * @param timeBegin	开始时间
	 * @param timeEnd	结束时间
	 * @return
	 */
	public List<T> findByTime(String timeBegin, String timeEnd, int page, int pageSize);
	
	/**根据时间区间查找
	 * @param timeBegin	开始时间
	 * @param timeEnd	结束时间
	 * @param property  准备以那个属性来排序
	 * @param isAsc		是否是升序
	 * @return
	 */
	public List<T> findByTime(String timeBegin, String timeEnd, int page, int pageSize, String property, boolean isAsc);
	
	/**获取该条件下的记录数量
	 * @param timeBegin	开始时间
	 * @param timeEnd	结果时间
	 * @return
	 */
	public Integer getFindByTimeSize(String timeBegin, String timeEnd);
	
	/**创建相关hql语句
	 * @param timeBegin
	 * @param timeEnd
	 * @return
	 */
	public String createFindByTimeHql(String timeBegin, String timeEnd);


}
