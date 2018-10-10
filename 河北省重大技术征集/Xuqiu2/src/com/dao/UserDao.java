package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DUBtil.DBUtil;
import com.bean.Juesebean;
import com.bean.Userbean;


public class UserDao 
{
	public List<Userbean> userlist()
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		ResultSet rs=null;
		String sql="select * from user";
		List<Userbean> userlist=new ArrayList<Userbean>();
		Userbean userbean=null;
		try
		{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next())
			{
				userbean=new Userbean();
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
				userlist.add(userbean);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.close(rs, state, conn);
		}
		return userlist;
	}
	public void deleteuser(int userid)
	{

		Connection conn=DBUtil.getConn();
		Statement state=null;
		String sql="delete from user where id='"+userid+"'";
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
	public Userbean searchusershenfen(int id)//定义一个管理员身份的函数，返回值为管理员的对象
	{
		Connection conn=DBUtil.getConn();//建立连接数据库的连接
		Userbean userbean=null;
		Statement state=null;
		ResultSet rs=null;
		try
		{
			state=conn.createStatement();//定义状态
			 rs=state.executeQuery("select * from user where id='"+id+"'");//从数据库找到符合的管理员
			if(rs.next())
			{// 如果有结果，是认为是通过验证了
				
				
				userbean = new Userbean();
				userbean.setId(rs.getInt("id"));
				userbean.setShenfen(rs.getString("shenfen"));	
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


}
