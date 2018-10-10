package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.DUBtil.DBUtil;
import com.DUBtil.MD5;
import com.DUBtil.StringUtil;
import com.bean.Userbean;




public class Admindao 
{
	
	public void update(String username,String password,int id) //修改管理员信息，需要修改的信息存储在adminBean中
	{
		// TODO Auto-generated method stub
		String sql = "update user set username='" + username + "',password='" +
				password+ "' where id='" + id + "'";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		try 
		{
			state = conn.createStatement();
			state.executeUpdate(sql);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			DBUtil.close(state, conn);
		}

	}
	
	
	public Userbean checkLogin(String username, String password)//定义一个管理员身份的函数，返回值为管理员的对象
	{
		Connection conn=DBUtil.getConn();//建立连接数据库的连接
		Userbean userbean=null;
		Statement state=null;
		ResultSet rs=null;
		try
		{
			state=conn.createStatement();//定义状态
			 rs=state.executeQuery("select * from user where username='"+username+"'");//从数据库找到符合的管理员
			if(rs.next())
			{// 如果有结果，是认为是通过验证了
				if(rs.getString("password").equals(password))
				{
				
					userbean = new Userbean();
					userbean.setId(rs.getInt("id"));
					userbean.setShenfen(rs.getString("shenfen"));
					userbean.setUsername(rs.getString("username"));
					userbean.setPassword(rs.getString("password"));
					userbean.setName(rs.getString("name"));
					userbean.setShenfenhao(rs.getString("shenfenhao"));
					userbean.setShi(rs.getString("shi"));
					userbean.setDanwei(rs.getString("danwei"));
					userbean.setZhuanye(rs.getString("zhuanye"));
					userbean.setHangye(rs.getString("hangye"));
					userbean.setJiaoyu(rs.getString("jiaoyu"));
					userbean.setZhicheng(rs.getString("zhicheng"));
					userbean.setTongxundizhi(rs.getString("tongxundizhi"));
					userbean.setYouzhengbianma(rs.getString("youzhengbianma"));
					userbean.setShouji(rs.getString("shouji"));
					userbean.setDianhua(rs.getString("dianhua"));
					userbean.setYouxiang(rs.getString("youxiang"));	
					
				}
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.close(rs, state, conn);
		}
		return userbean;//返回管理远的信息对象，将数据库中查找的管理员用户信息返回
	}
	public boolean checkReg(String name)//检查是否有重复的管理员的函数
	{
		boolean flag = true;
		// 查询用户是否已存在
		Connection connection = DBUtil.getConn();//数据库连接
		Statement statement = null;//定义状态
		ResultSet rs = null;//定义数据集
		try
		{
			statement = connection.createStatement();
			rs = statement.executeQuery("select username from admin");
			while (rs.next()) 
			{
				if (name.equals(rs.getString("username"))) //如果有重复的用户名则，flag=false
				{

					flag = false;
				}
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally//执行关闭连接的语句
		{
			DBUtil.close(rs, statement, connection);//关闭连接
		}
		return flag;
	}
	public void req(Userbean userbean)
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		String shenfen="用户";
		String sql="insert into user(username,password,name,shenfenhao,shi,danwei,zhuanye,hangye,jiaoyu,zhicheng,tongxundizhi,youzhengbianma,shouji,dianhua,youxiang,shenfen) values('"
		+userbean.getUsername()+"','"+userbean.getPassword()+"','"+userbean.getName()+"','"+userbean.getShenfenhao()+"','"+
				userbean.getShi()+"','"+userbean.getDanwei()+"','"+userbean.getZhuanye()+"','"+userbean.getHangye()+"','"+
		userbean.getJiaoyu()+"','"+userbean.getZhicheng()+"','"+userbean.getTongxundizhi()+"','"+userbean.getYouzhengbianma()+"','"+
				userbean.getShouji()+"','"+userbean.getDianhua()+"','"+userbean.getYouxiang()+"','"+shenfen+"')";
		try
		{
			state=conn.createStatement();
			state.executeUpdate(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.close(state, conn);
		}
	}
	
	

}
