package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DUBtil.StringUtil;
import com.alibaba.fastjson.JSON;
import com.bean.Juesebean;
import com.bean.Userbean;
import com.dao.Quanxiandao;
import com.dao.UserDao;

@SuppressWarnings("serial")
public class Quanxianservlet  extends HttpServlet
{
	protected void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		String method=req.getParameter("method");
		if(method.equals("searchquanxian"))
		{
			searchquanxian(req,resp);
		}
		else if(method.equals("showquanxian"))
		{
			showquanxian(req,resp);
		}
		else if(method.equals("fenpeijuese"))
		{
			fenpeijuese(req,resp);
		}
		else if(method.equals("addjuese"))
		{
			addjuese(req,resp);
		}
		else if(method.equals("jueselist"))
		{
			jueselist(req,resp);
		}
		else if(method.equals("feipeiquanxian"))
		{
			feipeiquanxian(req,resp);
		}
		else if(method.equals("deletejuese"))
		{
			deletejuese(req,resp);
		}
		
		
	}
	protected void deletejuese(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		Quanxiandao quanxiandao=new Quanxiandao();
		String juese=req.getParameter("juese");
		quanxiandao.deletejuee(juese);
		List<Juesebean> jueselist=quanxiandao.jueselist();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(jueselist));
		out.flush();
		out.close();	
	}
	protected void feipeiquanxian(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		Quanxiandao quanxiandao=new Quanxiandao();
		String juese=req.getParameter("juese");
		int tianbao=StringUtil.StringToInt(req.getParameter("tianbao"));
		int chakangerenshenhexuqiu=StringUtil.StringToInt(req.getParameter("chakangerenshenhexuqiu"));
		int chakanquanbushenhexuqiu=StringUtil.StringToInt(req.getParameter("chakanquanbushenhexuqiu"));
		int xuqiuxiugai=StringUtil.StringToInt(req.getParameter("xuqiuxiugai"));
		int chakanquanbu=StringUtil.StringToInt(req.getParameter("chakanquanbu"));
		int chakangeren=StringUtil.StringToInt(req.getParameter("chakangeren"));
		int chakantuihui=StringUtil.StringToInt(req.getParameter("chakantuihui"));
		int shenhexuqiu=StringUtil.StringToInt(req.getParameter("shenhexuqiu"));
		int chakanuser=StringUtil.StringToInt(req.getParameter("chakanuser"));
		int xinxixiugai=StringUtil.StringToInt(req.getParameter("xinxixiugai"));
		int mimaxiugai=StringUtil.StringToInt(req.getParameter("mimaxiugai"));
		System.out.println(tianbao+" "+chakanquanbushenhexuqiu);
		quanxiandao.fupeiquanxian(juese, tianbao, chakangerenshenhexuqiu, chakanquanbushenhexuqiu, xuqiuxiugai, chakanquanbu, chakangeren, chakantuihui, shenhexuqiu, chakanuser, xinxixiugai, mimaxiugai);
		List<Juesebean> jueselist=quanxiandao.jueselist();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(jueselist));
		out.flush();
		out.close();	
	}
	protected void jueselist(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		Quanxiandao quanxiandao=new Quanxiandao();
		List<Juesebean> jueselist=quanxiandao.jueselist();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(jueselist));
		out.flush();
		out.close();
		
	}
	protected void addjuese(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		String  newjuese=req.getParameter("newjuese");
		
		Quanxiandao quanxiandao=new Quanxiandao();
		quanxiandao.addjuee(newjuese);
		List<Juesebean> jueselist=quanxiandao.jueselist();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(jueselist));
		out.flush();
		out.close();
		
	}
	protected void fenpeijuese(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		int qxuserid=StringUtil.StringToInt(req.getParameter("qxuserid"));
		String qxjuese=req.getParameter("qxjuese");
		Quanxiandao quanxiandao=new Quanxiandao();
		quanxiandao.fenpeijuese(qxuserid, qxjuese);
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString("1"));
		out.flush();
		out.close();
		
	}
	protected void showquanxian(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		int userid=StringUtil.StringToInt(req.getParameter("userid"));
		UserDao userdao=new UserDao();
		Userbean userbean=userdao.searchusershenfen(userid);
		Quanxiandao quanxiandao=new Quanxiandao();
		Juesebean juesebean=quanxiandao.searchquanxian(userbean.getShenfen());
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(juesebean));
		out.flush();
		out.close();
	}
	protected void searchquanxian(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		String juese=req.getParameter("juese");
		
		Quanxiandao quanxiandao=new Quanxiandao();
		Juesebean juesebean=quanxiandao.searchquanxian(juese);
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(juesebean));
		out.flush();
		out.close();
	}
		
		
}