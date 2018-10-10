package com.xmy.web.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.xmy.domain.Student;
import com.xmy.service.IStudentService;

public class LoginAction extends BaseAction {
	private IStudentService studentService;
	private String stuName;
	private String stuPwd;

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	// 进入登录
	@Override
	public String execute() throws Exception {
		return LOGIN;
	}

	// 处理登录请求
	@InputConfig(resultName = "login")
	public String check() throws Exception {
		Student student = studentService.findByLogin(stuName, stuPwd);
		// 登录成功之后，把user对象(有id)放入session中
		if (student != null && "admin".equals(student.getStuName())) {
			ActionContext.getContext().getSession().put("studentInsession", student);
			return "main";// 重定向后台主页
		}else if(student != null){
			ActionContext.getContext().getSession().put("studentInsession", student);
			return "stu";// 重定向后台主页
		}
		addActionError("登录失败"); 
		return LOGIN;
	}

	// 注销退出
	public String logout() throws Exception {
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuPwd() {
		return stuPwd;
	}

	public void setStuPwd(String stuPwd) {
		this.stuPwd = stuPwd;
	}

}
