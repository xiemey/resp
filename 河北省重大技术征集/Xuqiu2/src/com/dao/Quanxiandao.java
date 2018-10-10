package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DUBtil.DBUtil;
import com.bean.Juesebean;
import com.bean.Juesebean;

public class Quanxiandao 
{
	public List<Juesebean> jueselist()
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		ResultSet rs=null;
		String sql="select * from quanxian";
		List<Juesebean> userlist=new ArrayList<Juesebean>();
		Juesebean juesebean=null;
		try
		{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next())
			{
				juesebean=new Juesebean();
				juesebean.setName(rs.getString("juese"));
				juesebean.setTianbao(rs.getInt("tianbao"));
				juesebean.setChakangerenshenhexuqiu(rs.getInt("chakangerenshenhexuqiu"));
				juesebean.setChakanquanbushenhexuqiu(rs.getInt("chakanquanbushenhexuqiu"));
				juesebean.setXuqiuxiugai(rs.getInt("xuqiuxiugai"));
				juesebean.setChakanquanbu(rs.getInt("chakanquanbu"));
				juesebean.setChakantuihui(rs.getInt("chakantuihui"));
				juesebean.setShenhexuqiu(rs.getInt("shenhexuqiu"));
				juesebean.setChakanuser(rs.getInt("chakanuser"));
				juesebean.setXinxixiugai(rs.getInt("xinxixiugai"));
				juesebean.setMimaxiugai(rs.getInt("mimaxiugai"));
				userlist.add(juesebean);
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
	public Juesebean searchquanxian(String juese)
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		ResultSet rs=null;
		String sql="select * from quanxian where juese='"+juese+"'";
		Juesebean juesebean=null;
		try
		{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			if(rs.next())
			{
				juesebean=new Juesebean();
				juesebean.setName(rs.getString("juese"));
				juesebean.setTianbao(rs.getInt("tianbao"));
				juesebean.setChakangerenshenhexuqiu(rs.getInt("chakangerenshenhexuqiu"));
				juesebean.setChakanquanbushenhexuqiu(rs.getInt("chakanquanbushenhexuqiu"));
				juesebean.setXuqiuxiugai(rs.getInt("xuqiuxiugai"));
				juesebean.setChakangeren(rs.getInt("chakangeren"));
				juesebean.setChakanquanbu(rs.getInt("chakanquanbu"));
				juesebean.setChakantuihui(rs.getInt("chakantuihui"));
				juesebean.setShenhexuqiu(rs.getInt("shenhexuqiu"));
				juesebean.setChakanuser(rs.getInt("chakanuser"));
				juesebean.setXinxixiugai(rs.getInt("xinxixiugai"));
				juesebean.setMimaxiugai(rs.getInt("mimaxiugai"));
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
		return juesebean;
	}
	public void fenpeijuese(int id,String shenfen)
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		String sql="update user set shenfen='"+shenfen+"' where id='"+id+"'";
	
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
	public void addjuee(String juese)
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		String sql="insert into quanxian(juese) values('"+juese+"')";
		
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
	public void fupeiquanxian(String juese,int tianbao,int chakangerenshenhexuqiu,int chakanquanbushenhexuqiu,int xuqiuxiugai,int chakanquanbu,int chakangeren,int chakantuihui,int shenhexuqiu,int chakanuser,int xinxixiugai,int mimaxiugai)
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		String sql="update quanxian set tianbao='"+tianbao+"',chakangerenshenhexuqiu='"+
		chakangerenshenhexuqiu+"',chakanquanbushenhexuqiu='"+chakanquanbushenhexuqiu+"',xuqiuxiugai='"+
		xuqiuxiugai+"',chakanquanbu='"+chakanquanbu+"',chakangeren='"+chakangeren+"',chakantuihui='"+
		chakantuihui+"',shenhexuqiu='"+shenhexuqiu+"',chakanuser='"+chakanuser+"',xinxixiugai='"+xinxixiugai+"',mimaxiugai='"+
		mimaxiugai+"' where juese='"+juese+"'";
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
	public void deletejuee(String juese)
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		String sql="delete from quanxian where juese='"+juese+"'";
		
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
