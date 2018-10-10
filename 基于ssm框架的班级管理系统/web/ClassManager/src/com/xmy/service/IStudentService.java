package com.xmy.service;

import com.xmy.domain.Student;

public interface IStudentService extends IBaseService<Student>{

	boolean findBystuNum(String stuNum);

	Student findByLogin(String stuName, String stuPwd);
}
