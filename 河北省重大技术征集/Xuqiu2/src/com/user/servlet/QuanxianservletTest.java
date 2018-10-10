package com.user.servlet;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.util.List;

import org.junit.Test;

import com.DUBtil.StringUtil;
import com.alibaba.fastjson.JSON;
import com.bean.Juesebean;
import com.dao.Quanxiandao;

public class QuanxianservletTest {

	@Test
	public void testFeipeiquanxian() {
		
		Quanxiandao quanxiandao=new Quanxiandao();
		String juese="用户";
		
		quanxiandao.fupeiquanxian(juese, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
		
			
	}

}
