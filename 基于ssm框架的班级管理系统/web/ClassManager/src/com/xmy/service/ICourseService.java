package com.xmy.service;

import java.util.List;

import com.xmy.domain.Course;

public interface ICourseService extends IBaseService<Course> {

	boolean findBycouNum(String couNum);

	boolean findBycouName(String couName);
	
}
