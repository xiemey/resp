package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DUBtil.StringUtil;
import com.alibaba.fastjson.JSON;
import com.bean.Hangyebean;
import com.bean.Tuihuibean;
import com.bean.Xuekebean;
import com.bean.Zhengjibean;
import com.dao.Xuqiudao;
import com.dao.user.Tuihuidao;
import com.dao.user.Userxuqiudao;

@SuppressWarnings("serial")
public class XuqiuServlet extends HttpServlet
{
	protected void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		String method=req.getParameter("method");
		if("tianbao".equals(method))
		{
			zhao(req,resp);
		}
		else if("erjixueke".equals(method))
		{
			erjixuke(req,resp);
		}
		else if("addneed".equals(method))
		{
			addneed(req,resp);
		}
		else if("needlist".equals(method))
		{
			needlist(req,resp);
		}
		else if("search".equals(method))
		{
			search(req,resp);	
		}
		else if("searchlist".equals(method))
		{
			searchlist(req,resp);	
		}
		else if("shenhe".equals(method))
		{
			shenhe(req,resp);	
		}
		else if("shenhedetail".equals(method))
		{
			shenhedetail(req,resp);	
		}
		else if("zhengjishenehe".equals(method))
		{
			zhengjishenehe(req,resp);	
		}
		else if("zhengjituihui".equals(method))
		{
			zhengjituihui(req,resp);	
		}
		else if("needhecha".equals(method))
		{
			needhecha(req,resp);	
		}
		else if("needhechadetail".equals(method))
		{
			needhechadetail(req,resp);	
		}
		else if("needshangchuan".equals(method))
		{
			needshangchuan(req,resp);	
		}
		else if("needdelete".equals(method))
		{
			needdelete(req,resp);	
		}
		else if("tuihuiliulan".equals(method))
		{
			tuihuiliulan(req,resp);	
		}
		else if("tuihuiliulandetail".equals(method))
		{
			tuihuiliulandetail(req,resp);	
		}
		else if("tuihuineeddelete".equals(method))
		{
			tuihuineeddelete(req,resp);	
		}
	}
	protected void tuihuineeddelete(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		Userxuqiudao userxuqiudao=new Userxuqiudao();
		int id=StringUtil.StringToInt(req.getParameter("id"));
		int userid=StringUtil.StringToInt(req.getParameter("userid"));
		int status=3;
		userxuqiudao.needdeleta(id);
        List<Zhengjibean>zhengjibeanlist=userxuqiudao.tiaojianneedlsit(status,userid);
		req.setAttribute("zhengjibeanlist", zhengjibeanlist);
		req.getRequestDispatcher("/index/tuihuiliulan.jsp?status=1").forward(req, resp);
		
	}
	protected void tuihuiliulan(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		Userxuqiudao userxuqiudao=new Userxuqiudao();
		int status=StringUtil.StringToInt(req.getParameter("status"));
		int userid=StringUtil.StringToInt(req.getParameter("userid"));
		List<Zhengjibean>zhengjibeanlist=userxuqiudao.tiaojianneedlsit(status,userid);
		req.setAttribute("zhengjibeanlist", zhengjibeanlist);
		req.getRequestDispatcher("/index/tuihuiliulan.jsp").forward(req, resp);
		
	}
	protected void tuihuiliulandetail(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		Userxuqiudao xuqiudao=new Userxuqiudao();
		int id=StringUtil.StringToInt(req.getParameter("id"));
		Zhengjibean zhengjibean=xuqiudao.searchneed(id);
		Tuihuidao tuihuidao=new Tuihuidao();
		Tuihuibean tuihuibean=tuihuidao.searchtui(id);
		req.setAttribute("zhengjibean", zhengjibean);
		req.setAttribute("tuihuibean", tuihuibean);
		req.getRequestDispatcher("/index/tuihuiliulandetail.jsp").forward(req, resp);
	}
	protected void needdelete(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		Userxuqiudao userxuqiudao=new Userxuqiudao();
		int id=StringUtil.StringToInt(req.getParameter("id"));
		int userid=StringUtil.StringToInt(req.getParameter("userid"));
		int status=0;
		userxuqiudao.needdeleta(id);
        List<Zhengjibean>zhengjibeanlist=userxuqiudao.tiaojianneedlsit(status,userid);
		req.setAttribute("zhengjibeanlist", zhengjibeanlist);
		req.getRequestDispatcher("/index/needhecha.jsp?status=2").forward(req, resp);
		
	}
	protected void needshangchuan(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		Userxuqiudao userxuqiudao=new Userxuqiudao();
		int id=StringUtil.StringToInt(req.getParameter("id"));
		int userid=StringUtil.StringToInt(req.getParameter("userid"));
		int status=0;
		userxuqiudao.needshangchuan(id);
        List<Zhengjibean>zhengjibeanlist=userxuqiudao.tiaojianneedlsit(status,userid);
		req.setAttribute("zhengjibeanlist", zhengjibeanlist);
		req.getRequestDispatcher("/index/needhecha.jsp?status=1").forward(req, resp);
		
	}
	
	protected void needhecha(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		Xuqiudao userxuqiudao=new Xuqiudao();
		int status=StringUtil.StringToInt(req.getParameter("status"));
		int userid=StringUtil.StringToInt(req.getParameter("userid"));
		List<Zhengjibean>zhengjibeanlist=userxuqiudao.tiaojianneedlsit(status, userid);
		req.setAttribute("zhengjibeanlist", zhengjibeanlist);
		req.getRequestDispatcher("/index/needhecha.jsp").forward(req, resp);
		
	}
	protected void needhechadetail(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		Xuqiudao userxuqiudao=new Xuqiudao();
		int id=StringUtil.StringToInt(req.getParameter("id"));
		Zhengjibean zhengjibean=userxuqiudao.searchneed(id);
		req.setAttribute("zhengjibean", zhengjibean);
		req.getRequestDispatcher("/index/needhechadetail.jsp").forward(req, resp);
	}
	protected void zhengjishenehe(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		int id=StringUtil.StringToInt(req.getParameter("id"));
		Xuqiudao userxuqiudao=new Xuqiudao();
		userxuqiudao.zhengjishenehe(1,id);
		Zhengjibean zhengjibean=userxuqiudao.searchneed(id);
		req.setAttribute("zhengjibean", zhengjibean);
		req.getRequestDispatcher("/index/shenhedetail.jsp?status=1").forward(req, resp);
	}
	protected void zhengjituihui(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		int id=StringUtil.StringToInt(req.getParameter("id"));
		String liyou=req.getParameter("tuihuiliyou");
		Xuqiudao userxuqiudao=new Xuqiudao();
		userxuqiudao.zhengjishenehe(3,id);
		Zhengjibean zhengjibean=userxuqiudao.searchneed(id);
		Tuihuidao tuihuidao=new Tuihuidao();
		tuihuidao.tuihuiliyou(id, liyou);
		req.setAttribute("zhengjibean", zhengjibean);
		req.getRequestDispatcher("/index/shenhedetail.jsp?status=2").forward(req, resp);
	}
	protected void shenhedetail(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		Xuqiudao userxuqiudao=new Xuqiudao();
		int id=StringUtil.StringToInt(req.getParameter("id"));
		Zhengjibean zhengjibean=userxuqiudao.searchneed(id);
		req.setAttribute("zhengjibean", zhengjibean);
		req.getRequestDispatcher("/index/shenhedetail.jsp").forward(req, resp);
	}
	protected void shenhe(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		int status=StringUtil.StringToInt(req.getParameter("status"));
		Xuqiudao userxuqiudao=new Xuqiudao();
		List<Zhengjibean>zhengjibeanlist=userxuqiudao.shenhe(status);
		req.setAttribute("zhengjibeanlist", zhengjibeanlist);
		req.getRequestDispatcher("/index/shenhe.jsp").forward(req, resp);
		
	}
	protected void searchlist(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		Xuqiudao userxuqiudao=new Xuqiudao();
		String jiname=req.getParameter("name");
		int status=StringUtil.StringToInt(req.getParameter("status"));
		List<Zhengjibean>zhengjibeanlist=userxuqiudao.searchlsit(jiname,status);
		req.setAttribute("zhengjibeanlist", zhengjibeanlist);
		req.getRequestDispatcher("/index/listneed.jsp").forward(req, resp);
		
	}
	protected void search(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		Xuqiudao userxuqiudao=new Xuqiudao();
		int id=StringUtil.StringToInt(req.getParameter("id"));
		Zhengjibean zhengjibean=userxuqiudao.searchneed(id);
		req.setAttribute("zhengjibean", zhengjibean);
		req.getRequestDispatcher("/index/needdetail.jsp").forward(req, resp);
	}
	protected void needlist(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		Xuqiudao userxuqiudao=new Xuqiudao();
		List<Zhengjibean>zhengjibeanlist=userxuqiudao.needlsit();
		req.setAttribute("zhengjibeanlist", zhengjibeanlist);
		req.getRequestDispatcher("/index/listneed.jsp").forward(req, resp);
		
	}
	protected void erjixuke(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		Xuqiudao userxuqiudao=new Xuqiudao();
		List<Xuekebean> xuekebeanlist=userxuqiudao.zhaoxueke();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(JSON.toJSONString(xuekebeanlist));
		out.flush();
		out.close();
	}
	protected void addneed(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		Zhengjibean zhengjibean=new Zhengjibean();
		zhengjibean.setUserid(StringUtil.StringToInt(req.getParameter("id")));
		zhengjibean.setJiname(req.getParameter("jiname"));
		zhengjibean.setGuikou(req.getParameter("guikou"));
		zhengjibean.setTongxundizhi(req.getParameter("tongxundizhi"));
		zhengjibean.setSuozaidiyu(req.getParameter("suozaidiyu"));
		zhengjibean.setWangzhi(req.getParameter("wangzhi"));
		zhengjibean.setDianzixinxiang(req.getParameter("dianzixinxiang"));
		zhengjibean.setFarendaibiao(req.getParameter("farendaibiao"));
		zhengjibean.setYouzhengbianma(req.getParameter("youzhengbianma"));
		zhengjibean.setLianxi(req.getParameter("lianxi"));
		zhengjibean.setDianhua(req.getParameter("dianhua"));
		zhengjibean.setShouji(req.getParameter("shouji"));
		zhengjibean.setChuangzhen(req.getParameter("chuangzhen"));
		zhengjibean.setJigoushuxing(req.getParameter("jigoushuxing"));
		zhengjibean.setJigoujianjie(req.getParameter("jigoujianjie"));
		zhengjibean.setJishuxuqiuname(req.getParameter("jishuxuqiuname"));
		zhengjibean.setXuqiuqianyear(req.getParameter("xuqiuqianyear"));
		zhengjibean.setXuqiuhouyear(req.getParameter("xuqiuhouyear"));
		zhengjibean.setXuqiugaishu(req.getParameter("xuqiugaishu"));
		zhengjibean.setGuanjian1(req.getParameter("guanjian1"));
		zhengjibean.setGuanjian2(req.getParameter("guanjian2"));
		zhengjibean.setGuanjian3(req.getParameter("guanjian3"));
		zhengjibean.setGuanjian4(req.getParameter("guanjian4"));
		zhengjibean.setGuanjian5(req.getParameter("guanjian5"));
		zhengjibean.setJine(req.getParameter("jine"));
		zhengjibean.setXuqiujiejuefangshi(req.getParameter("xuqiujiejuefangshi"));
		zhengjibean.setHezuodanwei(req.getParameter("hezuodanwei"));
		zhengjibean.setKejihuodongleixing(req.getParameter("kejihuodongleixing"));
		zhengjibean.setXuekenfenlei(req.getParameter("xuekenfenlei"));
		zhengjibean.setTwoxueke(req.getParameter("twoxueke"));
		zhengjibean.setLingyu(req.getParameter("lingyu"));
		zhengjibean.setHangye(req.getParameter("hangye"));
		Xuqiudao userxuqiudao=new Xuqiudao();
		userxuqiudao.addneed(zhengjibean);
		List<Xuekebean> xuekebeanlist=userxuqiudao.zhaoxueke();
		List<Hangyebean> hangyelist=userxuqiudao.zhaohangye();
		req.setAttribute("xuekeBeans", xuekebeanlist);
		req.setAttribute("hangyeBeans", hangyelist);
		req.getRequestDispatcher("/index/addneed1.jsp?status=1").forward(req, resp);
	}
	protected void zhao(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		req.setCharacterEncoding("utf-8");
		Xuqiudao xuqiudao=new Xuqiudao();
		List<Xuekebean> xuekebeanlist=xuqiudao.zhaoxueke();
		List<Hangyebean> hangyelist=xuqiudao.zhaohangye();
		req.setAttribute("xuekeBeans", xuekebeanlist);
		req.setAttribute("hangyeBeans", hangyelist);
		req.getRequestDispatcher("/index/addneed1.jsp").forward(req, resp);
	}
		

}
