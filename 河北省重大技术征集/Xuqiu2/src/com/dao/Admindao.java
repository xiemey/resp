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
	
	public void update(String username,String password,int id) //�޸Ĺ���Ա��Ϣ����Ҫ�޸ĵ���Ϣ�洢��adminBean��
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
	
	
	public Userbean checkLogin(String username, String password)//����һ������Ա��ݵĺ���������ֵΪ����Ա�Ķ���
	{
		Connection conn=DBUtil.getConn();//�����������ݿ������
		Userbean userbean=null;
		Statement state=null;
		ResultSet rs=null;
		try
		{
			state=conn.createStatement();//����״̬
			 rs=state.executeQuery("select * from user where username='"+username+"'");//�����ݿ��ҵ����ϵĹ���Ա
			if(rs.next())
			{// ����н��������Ϊ��ͨ����֤��
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
		return userbean;//���ع���Զ����Ϣ���󣬽����ݿ��в��ҵĹ���Ա�û���Ϣ����
	}
	public boolean checkReg(String name)//����Ƿ����ظ��Ĺ���Ա�ĺ���
	{
		boolean flag = true;
		// ��ѯ�û��Ƿ��Ѵ���
		Connection connection = DBUtil.getConn();//���ݿ�����
		Statement statement = null;//����״̬
		ResultSet rs = null;//�������ݼ�
		try
		{
			statement = connection.createStatement();
			rs = statement.executeQuery("select username from admin");
			while (rs.next()) 
			{
				if (name.equals(rs.getString("username"))) //������ظ����û�����flag=false
				{

					flag = false;
				}
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally//ִ�йر����ӵ����
		{
			DBUtil.close(rs, statement, connection);//�ر�����
		}
		return flag;
	}
	public void req(Userbean userbean)
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		String shenfen="�û�";
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
