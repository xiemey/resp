package com.xmy.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.xmy.dao.BaseDao;
import com.xmy.query.BaseQuery;
import com.xmy.query.PageList;
import com.xmy.service.IBaseService;

/**
 * 
 * 公共业务类,不能实例化，不能把BaseServiceImpl配置到spring的class里面
 *
 * 
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {
	protected BaseDao<T> baseDao;
	private Class<T> entityClass;

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	public BaseServiceImpl() {
		// getClass() 返回此 Object 的运行时类。
		// public final native Class<?> getClass();
		// new BaseServiceImpl 返回就是父类（如果把父类定义为抽象） new EmployeeServiceImpl返回就是子类
		Class clazz = getClass();// 因为父类是抽象的，决定返回子类的实例
		// System.out.println("BaseServiceImpl clazz:" + clazz);
		// getGenericSuperclass() 返回表示此 Class 所表示的实体的直接父类的 Type。
		// EmployeeServiceImpl extends BaseServiceImpl<Employee>
		// java.lang.reflect.Type标示接口，里面什么代码都没有
		Type type = clazz.getGenericSuperclass();// BaseServiceImpl<Employee>的类型Type
		// System.out.println("BaseServiceImpl type:" + type);
		if (type instanceof ParameterizedType) {
			// ParameterizedType 表示参数化类型，如 Collection<String>。
			ParameterizedType parameterizedType = (ParameterizedType) type;
			// getActualTypeArguments() 返回表示此类型实际类型参数的 Type 对象的数组。<Employee>
			entityClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		}
		System.out.println("BaseServiceImpl entityClass:" + entityClass);
	}

	public void save(T t) {
		baseDao.save(t);
	}

	public void update(T t) {
		baseDao.update(t);
	}

	public void delete(Serializable id) {
		baseDao.delete(entityClass, id);
	}

	public T get(Serializable id) {
		return baseDao.get(entityClass, id);
	}

	public List<T> getAll() {
		return baseDao.getAll(entityClass);
	}

	
	public PageList findByQuery(BaseQuery baseQuery) {
		return baseDao.findByQuery(baseQuery);
	}

}
