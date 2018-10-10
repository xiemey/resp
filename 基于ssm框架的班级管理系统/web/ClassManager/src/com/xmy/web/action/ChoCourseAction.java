package com.xmy.web.action;

import com.xmy.service.IClasService;
import com.xmy.service.ICourseService;
import com.xmy.service.IScoreService;
import com.xmy.service.IStudentService;

public class ChoCourseAction extends BaseAction {
	private IStudentService studentService;
	private IScoreService scoreService;
	private ICourseService courseService;
	private IClasService clasService;
	private Long couId;
	private Long clasId;

	public Long getCouId() {
		return couId;
	}

	public void setCouId(Long couId) {
		this.couId = couId;
	}

	public Long getClasId() {
		return clasId;
	}

	public void setClasId(Long clasId) {
		this.clasId = clasId;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public void setScoreService(IScoreService scoreService) {
		this.scoreService = scoreService;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	public void setClasService(IClasService clasService) {
		this.clasService = clasService;
	}

	@Override
	public String execute() throws Exception {
		putContext("allClas", clasService.getAll());
		putContext("allCourses", courseService.getAll());
		return SUCCESS;
	}

}
