package com.user.servlet;

import static org.junit.Assert.*;

import java.awt.List;

import org.apache.catalina.User;
import org.junit.Test;

import com.dao.UserDao;
import com.bean.Userbean;

public class UserservletTest {

	@Test
	public void testUserdelete() {
		UserDao userDao = new UserDao();
		userDao.deleteuser(14);
		
	}

}
