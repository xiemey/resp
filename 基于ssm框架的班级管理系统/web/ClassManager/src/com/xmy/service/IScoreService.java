package com.xmy.service;

import java.math.BigDecimal;
import java.util.List;

import com.xmy.domain.Score;

public interface IScoreService extends IBaseService<Score> {
	List<Object[]> findMaxMin();

	List<Object[]> findMaxMin(Long couId);

	List<Object[]> findStuCourse(String stuNum);
	
	BigDecimal findTotalcouCre(String stuNum);
	
	Score findBystucou(String stuNum,String couName);
}
