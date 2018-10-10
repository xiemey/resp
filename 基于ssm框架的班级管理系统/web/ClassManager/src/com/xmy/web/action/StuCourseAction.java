package com.xmy.web.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.xmy.service.ICourseService;
import com.xmy.service.IScoreService;
import com.xmy.service.IStudentService;

public class StuCourseAction extends BaseAction {
	private IStudentService studentService;
	private ICourseService courseService;
	private IScoreService scoreService;
	private String stuNum;
	private List list = new ArrayList();
	private BigDecimal totalcouCre;

	@Override
	public String execute() throws Exception {
		System.out.println(stuNum);
		totalcouCre = scoreService.findTotalcouCre(stuNum);
		list = scoreService.findStuCourse(stuNum);
		putContext("allCourses", courseService.getAll());
		putContext("list", list);
		return SUCCESS;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public List<Object[]> getList() {
		return list;
	}

	public void setList(List<Object[]> list) {
		this.list = list;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	public void setScoreService(IScoreService scoreService) {
		this.scoreService = scoreService;
	}

	public BigDecimal getTotalcouCre() {
		return totalcouCre;
	}

	public void setTotalcouCre(BigDecimal totalcouCre) {
		this.totalcouCre = totalcouCre;
	}

}
