package com.xmy.web.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.xmy.domain.Clas;
import com.xmy.domain.Student;
import com.xmy.query.PageList;
import com.xmy.query.StudentQuery;
import com.xmy.service.IClasService;
import com.xmy.service.IStudentService;

public class StudentAction extends CRUDAction<Student> {
	private IStudentService studentService;
	private IClasService clasService;
	private Student student;
	private Clas clas;
	private PageList pageList;
	private StudentQuery baseQuery = new StudentQuery();
	private Long stuId;

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public void setClasService(IClasService clasService) {
		this.clasService = clasService;
	}

	@Override
	protected void list() throws Exception {
		logger.debug("list");
		this.pageList = studentService.findByQuery(baseQuery);
		putContext("allClas", clasService.getAll());
	}

	@Override
	public String input() throws Exception {
		logger.debug("input");
		putContext("allClas", clasService.getAll());
		return INPUT;
	}

	@Override
	@InputConfig(methodName = Action.INPUT)
	public String save() throws Exception {
		logger.debug("save");
		// 如果没有选择班级
		Clas clas = student.getClas();
		if (clas != null && clas.getClasId() == -1) {
			student.setClas(null);
		}
		if (stuId == null) {
			baseQuery.setCurrentPage(Integer.MAX_VALUE);
			studentService.save(student);
		} else {
			studentService.update(student);
		}
		return RELOAD;
	}

	// ajax删除
	@Override
	public String delete() throws Exception {
		logger.debug("delete");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			if (stuId != null) {
				if ("admin".equals(studentService.get(stuId).getStuName())) {
					out.print("{\"success\":false,\"msg\":\"无法删除管理员\"}");
				} else {
					studentService.delete(stuId);
					out.print("{\"success\":true,\"msg\":\"删除成功\"}");
				}
			} else {
				out.print("{\"success\":false,\"msg\":\"删除失败：没有对应的数据\"}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("{\"success\":false,\"msg\":\"<font color='red'>异常信息："
					+ e.getMessage() + "</font>\"}");
		}
		return NONE;
	}

	@Override
	public void prepareInput() throws Exception {
		if (stuId != null) {
			student = studentService.get(stuId);
		}
	}

	@Override
	public void prepareSave() throws Exception {
		if (stuId != null) {
			// 保存修改后没有出现在jsp页面的属性不丢失
			student = studentService.get(stuId);
			// 此时Clas是持久状态
			// 改变student的Clas不能是持久状态
			student.setClas(null);
		} else {
			// 新增后的保存
			student = new Student();
		}
	}

	public Student getModel() {
		return student;
	}

	public StudentQuery getBaseQuery() {
		return baseQuery;
	}

	public void setBaseQuery(StudentQuery baseQuery) {
		this.baseQuery = baseQuery;
	}

	public Long getStuId() {
		return stuId;
	}

	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}

	public PageList getPageList() {
		return pageList;
	}

	// ajax验证学号是否重复
	private String stuNum;

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public Clas getClas() {
		return clas;
	}

	public void setClas(Clas clas) {
		this.clas = clas;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String checkstuNum() throws Exception {
		logger.debug("checkstuNum");
		System.out.println("checkstuNum:" + stuNum);
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		if (stuId == null) {// 新增直接验证用户名是否重复
			System.out.println(studentService.findBystuNum(stuNum));
			out.print(studentService.findBystuNum(stuNum));
		}
		return NONE;
	}

}
