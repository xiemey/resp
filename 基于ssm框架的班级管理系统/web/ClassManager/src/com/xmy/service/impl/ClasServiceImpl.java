package com.xmy.service.impl;

import java.util.List;

import com.xmy.domain.Clas;
import com.xmy.service.IClasService;

public class ClasServiceImpl extends BaseServiceImpl<Clas> implements IClasService {
	
	public boolean findByclasNum(String clasNum) {
		String hql = "select count(o) from Clas o where o.clasNum=?";
		List<Long> list = baseDao.findByHql(hql, clasNum);
		if (list.get(0) > 0) {// 班级编号重复
			return false;
		}
		return true;
	}
	
	public boolean findByclasName(String clasName) {
		String hql = "select count(o) from Clas o where o.clasName=?";
		List<Long> list = baseDao.findByHql(hql, clasName);
		//System.out.println(list.get(0));
		if (list.get(0) > 0) {// 班级名称重复
			return false;
		}
		return true;
	}
	
	
	
}
