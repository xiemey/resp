package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DUBtil.MD5;
import com.DUBtil.StringUtil;
import com.bean.Userbean;
import com.dao.Admindao;




@SuppressWarnings("serial")
public class Adminservlet extends HttpServlet
{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	//��jspҳ����ת����
	{
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");//��ȡ���ַ���ΪUTF-8
		String method = req.getParameter("method");//�õ�method�е����ݣ��ж�ִ���ĸ�����
		
		if ("login".equals(method))//��¼����
		{
			login(req, resp);
		}
		else if("reg".equals(method))
		{
			reg(req, resp);
		}
		else if("update".equals(method))
		{
			updateuser(req, resp);
		}
		
	}
	protected void updateuser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.setCharacterEncoding("utf-8");//��ȡ���ַ���ΪUTF-8
		int id=StringUtil.StringToInt(req.getParameter("updateId"));
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Admindao admindao=new Admindao();
		admindao.update(username, password, id);
		resp.sendRedirect(req.getContextPath() + "/index/addUser.jsp?status=1");
		
	}
	private void reg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.setCharacterEncoding("utf-8");
		Userbean userbean=new Userbean();
		userbean.setUsername(req.getParameter("username"));
		userbean.setPassword(req.getParameter("password"));
		userbean.setName(req.getParameter("truename"));
		userbean.setShenfenhao(req.getParameter("cardid"));
		userbean.setShi(req.getParameter("city"));
		userbean.setDanwei(req.getParameter("depart"));
		userbean.setZhuanye(req.getParameter("director"));
		userbean.setHangye(req.getParameter("hangye"));
		userbean.setJiaoyu(req.getParameter("education"));
		userbean.setZhicheng(req.getParameter("zhicheng"));
		userbean.setTongxundizhi(req.getParameter("address"));
		userbean.setYouzhengbianma(req.getParameter("e_code"));
		userbean.setShouji(req.getParameter("Pnumber"));
		userbean.setDianhua(req.getParameter("dianhua"));
		userbean.setYouxiang(req.getParameter("email"));
		Admindao admindao = new Admindao();
		admindao.req(userbean);
		//�ж��Ƿ��¼�ɹ��������½�ɹ�����adminBean��Ϊ�գ�Ϊ���û���������Ϣ
		resp.sendRedirect(req.getContextPath() + "/login/register.jsp?status=1");
		
	}
	
	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");//��JSP�����ȡ�û���
		String password = req.getParameter("password");//��JSPҳ���ȡ���벢����MD5����
		Admindao adminDao = new Admindao();
		Userbean userbean = adminDao.checkLogin(username, password);//�ж��Ƿ��¼�ɹ��������½�ɹ�����adminBean��Ϊ�գ�Ϊ���û���������Ϣ
		if(userbean==null)
		{
			
			resp.sendRedirect(req.getContextPath() + "/login/login.jsp?status=1");
		}
		else
		{
			if(userbean.getShenfen().equals("管理员"))
			{
			req.getSession().setAttribute("user", userbean);
			resp.sendRedirect(req.getContextPath() + "/index/index.jsp");
			}
			else
			{
			req.getSession().setAttribute("user", userbean);
			resp.sendRedirect(req.getContextPath() + "/user/index.jsp");
			}
		}
			
			
		
	}
	

}
