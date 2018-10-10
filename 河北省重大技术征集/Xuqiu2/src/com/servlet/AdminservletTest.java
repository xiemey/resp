package com.servlet;

import static org.junit.Assert.*;

import org.junit.Test;

import com.DUBtil.StringUtil;
import com.bean.Userbean;
import com.dao.Admindao;

public class AdminservletTest {

	@Test
	public void testUpdateuser() {
		
		
		String username = "admin";
		String password = "123456";
		Admindao admindao=new Admindao();
		admindao.update(username, password, 1);
		
	}
	@Test
	public void testregr() {
		Userbean userbean=new Userbean();
		userbean.setUsername("admin");
		userbean.setPassword("123456");
		Admindao admindao = new Admindao();
		admindao.req(userbean);
	}

	
}
