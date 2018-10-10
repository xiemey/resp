package com.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bean.Userbean;

public class AdmindaoTest {
	Admindao admin =new Admindao();
	@Test
	public void testReq() {
		Userbean userbean  = admin.checkLogin("admin", "123456");
		System.out.println(userbean);
	}
	

	@Test
	public void testUp() {
		Userbean userbean  ; admin.update("admin", "123456", 1);
		System.out.println();
		
	}
}
