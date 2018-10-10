package com.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DUBtil.StringUtil;
import com.bean.Juesebean;
import com.bean.Userbean;
import com.dao.Quanxiandao;
import com.dao.UserDao;

@SuppressWarnings("serial")
public class Userservlet extends HttpServlet
{
	protected void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		String method=req.getParameter("method");
		if(method.equals("userlist"))
		{
			userlit(req,resp);
		}
		else if(method.equals("userdelete"))
		{
			userdelete(req,resp);
		}
		else if(method.equals("quanxian"))
		{
			quanxian(req,resp);
		}
		
	}
	protected void quanxian(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		UserDao userdao=new UserDao();
		List<Userbean> userlists=userdao.userlist();
		Quanxiandao quanxiandao=new Quanxiandao();
		List<Juesebean> jueselists=quanxiandao.jueselist();
		req.setAttribute("Userlists", userlists);
		req.setAttribute("Jueselists", jueselists);
		req.getRequestDispatcher("/index/quanxian.jsp").forward(req, resp);
	}
	protected void userdelete(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		int id=StringUtil.StringToInt(req.getParameter("userid"));
		UserDao userdao=new UserDao();
		userdao.deleteuser(id);
		List<Userbean> userlists=userdao.userlist();
		req.setAttribute("Userlists", userlists);
		req.getRequestDispatcher("/index/userlist.jsp?status=1").forward(req, resp);
	}
	protected void userlit(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		UserDao userdao=new UserDao();
		List<Userbean> userlists=userdao.userlist();
		req.setAttribute("Userlists", userlists);
		req.getRequestDispatcher("/index/userlist.jsp").forward(req, resp);
	}
	
}

