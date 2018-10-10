package com.dao.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.DUBtil.DBUtil;
import com.bean.Tuihuibean;


public class Tuihuidao 
{
	public Tuihuibean searchtui(int zhengjiid)
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		ResultSet rs=null;
		Tuihuibean tuihuibean=new Tuihuibean();
		String sql="select * from tuihui where zhengjiid='"+zhengjiid+"'";
		try
		{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			if(rs.next())
			{
			tuihuibean.setId(rs.getInt("id"));
			tuihuibean.setZhengjiid(zhengjiid);
			tuihuibean.setTuihui(rs.getString("tuihui"));
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
		return tuihuibean;
		
	}
	public void tuihuiliyou(int zhengjiid,String liyou)
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		Tuihuibean tuihuibean=new Tuihuibean();
		String sql="insert into tuihui(zhengjiid,tuihui) values('"+zhengjiid+"','"+liyou+"')";
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
