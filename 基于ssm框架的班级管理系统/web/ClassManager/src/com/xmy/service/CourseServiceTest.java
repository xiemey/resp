package com.xmy.service;

import java.util.List;

import javax.mail.Session;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xmy.domain.Course;

public class CourseServiceTest extends BaseServiceTest{
	@Autowired
	ICourseService courseService;
	IScoreService scoreService;
	
	@Test
	public void test() {
		
	}
}
