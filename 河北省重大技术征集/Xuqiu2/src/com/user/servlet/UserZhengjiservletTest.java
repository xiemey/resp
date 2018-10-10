package com.user.servlet;

import static org.junit.Assert.*;

import org.junit.Test;

import com.DUBtil.StringUtil;
import com.bean.Zhengjibean;

public class UserZhengjiservletTest {

	@Test
	public void testAddneed() {
		
		Zhengjibean zhengjibean=new Zhengjibean();
		zhengjibean.setUserid(13);
		zhengjibean.setJiname("12");
		zhengjibean.setGuikou("12");
		zhengjibean.setTongxundizhi("12");
	}

}
