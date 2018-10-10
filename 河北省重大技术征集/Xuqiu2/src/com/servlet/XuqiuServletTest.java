package com.servlet;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.DUBtil.StringUtil;
import com.bean.Zhengjibean;
import com.dao.Xuqiudao;
import com.dao.user.Userxuqiudao;

public class XuqiuServletTest {
	Xuqiudao userxuqiudao=new Xuqiudao();

	@Test
	public void testAddneed() {
		
		Zhengjibean zhengjibean=new Zhengjibean();
		zhengjibean.setUserid(5);
		zhengjibean.setJiname("hebi");
		zhengjibean.setGuikou("kdfjh");
		userxuqiudao.addneed(zhengjibean);
	}

	@Test
	public void testneeddelete() {
		
		Userxuqiudao userxuqiudao=new Userxuqiudao();
		
		userxuqiudao.needdeleta(4);
        List<Zhengjibean>zhengjibeanlist=userxuqiudao.tiaojianneedlsit(0,4);
		
	}
	@Test
	public void testuihui() {
		
		
		Userxuqiudao userxuqiudao=new Userxuqiudao();
		
		userxuqiudao.needdeleta(3);
        List<Zhengjibean>zhengjibeanlist=userxuqiudao.tiaojianneedlsit(0,3);
		
		
		
	}
}
