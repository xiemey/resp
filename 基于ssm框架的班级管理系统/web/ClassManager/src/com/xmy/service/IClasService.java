package com.xmy.service;

import com.xmy.domain.Clas;

public interface IClasService extends IBaseService<Clas> {
	
	boolean findByclasNum(String clasNum);
	
	boolean findByclasName(String clasName);
	
}
