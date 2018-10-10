package com.dao.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DUBtil.DBUtil;
import com.DUBtil.StringUtil;
import com.bean.Hangyebean;
import com.bean.Xuekebean;
import com.bean.Zhengjibean;

public class Userxuqiudao 
{
	public void needdeleta(int id)
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		ResultSet rs=null;
		String sql="delete from zhengji where id='"+id+"'";
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
			DBUtil.close(rs, state, conn);
		}
	}
	public void needshangchuan(int id)
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		ResultSet rs=null;
		String sql="update zhengji set status='1' where id='"+id+"'";
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
			DBUtil.close(rs, state, conn);
		}
	}
	public List<Xuekebean> zhaoxueke()
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		ResultSet rs=null;
		String sql="select * from xueke";
		List<Xuekebean> xuekebeanlist=new ArrayList<Xuekebean>();
		Xuekebean xuekebean=null;
		try
		{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next())
			{
				xuekebean=new Xuekebean();
				xuekebean.setId(rs.getInt("id"));
				xuekebean.setName(rs.getString("name"));
				xuekebeanlist.add(xuekebean);
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
		return xuekebeanlist;
	}
	public List<Hangyebean> zhaohangye()
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		ResultSet rs=null;
		String sql="select * from hangye";
		List<Hangyebean> hangyebeanlist=new ArrayList<Hangyebean>();
		Hangyebean hangyebean=null;
		try
		{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next())
			{
				hangyebean=new Hangyebean();
				hangyebean.setId(rs.getInt("id"));
				hangyebean.setName(rs.getString("name"));
				hangyebeanlist.add(hangyebean);
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
		return hangyebeanlist;
	}
	
	public List<Zhengjibean> tiaojianneedlsit(int status,int userid)
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		ResultSet rs=null;
		String sql="select * from zhengji where status='"+status+"' and userid='"+userid+"'";
		List<Zhengjibean> zhengjibeanlist=new ArrayList<Zhengjibean>();
		Zhengjibean zhengjibean=null;
		try
		{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next())
			{
				zhengjibean=new Zhengjibean();
				zhengjibean.setId(rs.getInt("id"));
				zhengjibean.setUserid(rs.getInt("userid"));
				zhengjibean.setJiname(rs.getString("jiname"));
				zhengjibean.setGuikou(rs.getString("guikou"));
				zhengjibean.setTongxundizhi(rs.getString("tongxundizhi"));
				zhengjibean.setSuozaidiyu(rs.getString("suozaidiyu"));
				zhengjibean.setWangzhi(rs.getString("wangzhi"));
				zhengjibean.setDianzixinxiang(rs.getString("dianzixinxiang"));
				zhengjibean.setFarendaibiao(rs.getString("farendaibiao"));
				zhengjibean.setYouzhengbianma(rs.getString("youzhengbianma"));
				zhengjibean.setLianxi(rs.getString("lianxi"));
				zhengjibean.setDianhua(rs.getString("dianhua"));
				zhengjibean.setShouji(rs.getString("shouji"));
				zhengjibean.setChuangzhen(rs.getString("chuangzhen"));
				zhengjibean.setJigoushuxing(rs.getString("jigoushuxing"));
				zhengjibean.setJigoujianjie(rs.getString("jigoujianjie"));
				zhengjibean.setJishuxuqiuname(rs.getString("jishuxuqiuname"));
				zhengjibean.setXuqiuqianyear(rs.getString("xuqiuqianyear"));
				zhengjibean.setXuqiuhouyear(rs.getString("xuqiuhouyear"));
				zhengjibean.setXuqiugaishu(rs.getString("xuqiugaishu"));
				zhengjibean.setGuanjian1(rs.getString("guanjian1"));
				zhengjibean.setGuanjian2(rs.getString("guanjian2"));
				zhengjibean.setGuanjian3(rs.getString("guanjian3"));
				zhengjibean.setGuanjian4(rs.getString("guanjian4"));
				zhengjibean.setGuanjian5(rs.getString("guanjian5"));
				zhengjibean.setJine(rs.getString("jine"));
				zhengjibean.setXuqiujiejuefangshi(rs.getString("xuqiujiejuefangshi"));
				zhengjibean.setHezuodanwei(rs.getString("hezuodanwei"));
				zhengjibean.setKejihuodongleixing(rs.getString("kejihuodongleixing"));
				zhengjibean.setXuekenfenlei(rs.getString("xuekenfenlei"));
				zhengjibean.setTwoxueke(rs.getString("twoxueke"));
				zhengjibean.setLingyu(rs.getString("lingyu"));
				zhengjibean.setHangye(rs.getString("hangye"));
				zhengjibean.setStatus(StringUtil.StringToInt(rs.getString("status")));
				zhengjibean.setCreatedate(rs.getString("createdate"));
				zhengjibeanlist.add(zhengjibean);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.close(rs,state, conn);
		}
		return zhengjibeanlist;
	}
	public void addneed(Zhengjibean zhengjibean)
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		String sql="insert into zhengji(jiname,guikou,tongxundizhi,suozaidiyu,wangzhi,dianzixinxiang,farendaibiao,youzhengbianma,lianxi,dianhua,shouji,chuangzhen,jigoushuxing,jigoujianjie,jishuxuqiuname,xuqiuqianyear,xuqiuhouyear,xuqiugaishu,guanjian1,guanjian2,guanjian3,guanjian4,guanjian5,jine,xuqiujiejuefangshi,hezuodanwei,kejihuodongleixing,xuekenfenlei,lingyu,hangye,userid,twoxueke,createdate) values('"+
				zhengjibean.getJiname()+ "','"+zhengjibean.getGuikou()+"','"+
				zhengjibean.getTongxundizhi()+"','"+zhengjibean.getSuozaidiyu()+"','"+zhengjibean.getWangzhi()+"','"+
				zhengjibean.getDianzixinxiang()+"','"+zhengjibean.getFarendaibiao()+"','"+zhengjibean.getYouzhengbianma()+"','"+
				zhengjibean.getLianxi()+"','"+zhengjibean.getDianhua()+"','"+zhengjibean.getShouji()+"','"+
				zhengjibean.getChuangzhen()+"','"+zhengjibean.getJigoushuxing()+"','"+zhengjibean.getJigoujianjie()+"','"+zhengjibean.getJishuxuqiuname() +"','"+
				zhengjibean.getXuqiuqianyear()+"','"+zhengjibean.getXuqiuhouyear()+"','"+zhengjibean.getXuqiugaishu()+"','"+zhengjibean.getGuanjian1()+"','"+
				zhengjibean.getGuanjian2()+"','"+zhengjibean.getGuanjian3()+"','"+zhengjibean.getGuanjian4()+"','"+zhengjibean.getGuanjian5()+"','"+
				zhengjibean.getJine()+"','"+zhengjibean.getXuqiujiejuefangshi()+"','"+zhengjibean.getHezuodanwei()+"','"+zhengjibean.getKejihuodongleixing()+"','"+
				zhengjibean.getXuekenfenlei()+"','"+zhengjibean.getLingyu()+"','"+zhengjibean.getHangye()+"','"+zhengjibean.getUserid()+"','"+zhengjibean.getTwoxueke()+"',now())";
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
	
	
	//上传需求浏览查看审核状态
	public List<Zhengjibean> needlist(int userid)
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		ResultSet rs=null;
		int status=0;
		String sql="select * from zhengji where userid='"+userid+"' and status!='"+status+"'";
		List<Zhengjibean> zhengjibeanlist=new ArrayList<Zhengjibean>();
		Zhengjibean zhengjibean=null;
		try
		{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next())
			{
				zhengjibean=new Zhengjibean();
				zhengjibean.setId(rs.getInt("id"));
				zhengjibean.setUserid(rs.getInt("userid"));
				zhengjibean.setJiname(rs.getString("jiname"));
				zhengjibean.setGuikou(rs.getString("guikou"));
				zhengjibean.setTongxundizhi(rs.getString("tongxundizhi"));
				zhengjibean.setSuozaidiyu(rs.getString("suozaidiyu"));
				zhengjibean.setWangzhi(rs.getString("wangzhi"));
				zhengjibean.setDianzixinxiang(rs.getString("dianzixinxiang"));
				zhengjibean.setFarendaibiao(rs.getString("farendaibiao"));
				zhengjibean.setYouzhengbianma(rs.getString("youzhengbianma"));
				zhengjibean.setLianxi(rs.getString("lianxi"));
				zhengjibean.setDianhua(rs.getString("dianhua"));
				zhengjibean.setShouji(rs.getString("shouji"));
				zhengjibean.setChuangzhen(rs.getString("chuangzhen"));
				zhengjibean.setJigoushuxing(rs.getString("jigoushuxing"));
				zhengjibean.setJigoujianjie(rs.getString("jigoujianjie"));
				zhengjibean.setJishuxuqiuname(rs.getString("jishuxuqiuname"));
				zhengjibean.setXuqiuqianyear(rs.getString("xuqiuqianyear"));
				zhengjibean.setXuqiuhouyear(rs.getString("xuqiuhouyear"));
				zhengjibean.setXuqiugaishu(rs.getString("xuqiugaishu"));
				zhengjibean.setGuanjian1(rs.getString("guanjian1"));
				zhengjibean.setGuanjian2(rs.getString("guanjian2"));
				zhengjibean.setGuanjian3(rs.getString("guanjian3"));
				zhengjibean.setGuanjian4(rs.getString("guanjian4"));
				zhengjibean.setGuanjian5(rs.getString("guanjian5"));
				zhengjibean.setJine(rs.getString("jine"));
				zhengjibean.setXuqiujiejuefangshi(rs.getString("xuqiujiejuefangshi"));
				zhengjibean.setHezuodanwei(rs.getString("hezuodanwei"));
				zhengjibean.setKejihuodongleixing(rs.getString("kejihuodongleixing"));
				zhengjibean.setXuekenfenlei(rs.getString("xuekenfenlei"));
				zhengjibean.setTwoxueke(rs.getString("twoxueke"));
				zhengjibean.setLingyu(rs.getString("lingyu"));
				zhengjibean.setHangye(rs.getString("hangye"));
				zhengjibean.setStatus(StringUtil.StringToInt(rs.getString("status")));
				zhengjibean.setCreatedate(rs.getString("createdate"));
				zhengjibeanlist.add(zhengjibean);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.close(rs,state, conn);
		}
		return zhengjibeanlist;
	}
	
	
	
	
	
	
	public List<Zhengjibean> searchlsit(String jiname,int status)
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		ResultSet rs=null;
		String sql=null;
		if(status==3)
		{
			sql="select * from zhengji where jiname='"+jiname+"'";
		}
		else
		{
			sql="select * from zhengji where jiname='"+jiname+"' and status='"+status+"'";
		}
		List<Zhengjibean> zhengjibeanlist=new ArrayList<Zhengjibean>();
		Zhengjibean zhengjibean=null;
		try
		{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next())
			{
				zhengjibean=new Zhengjibean();
				zhengjibean.setId(rs.getInt("id"));
				zhengjibean.setUserid(rs.getInt("userid"));
				zhengjibean.setJiname(rs.getString("jiname"));
				zhengjibean.setGuikou(rs.getString("guikou"));
				zhengjibean.setTongxundizhi(rs.getString("tongxundizhi"));
				zhengjibean.setSuozaidiyu(rs.getString("suozaidiyu"));
				zhengjibean.setWangzhi(rs.getString("wangzhi"));
				zhengjibean.setDianzixinxiang(rs.getString("dianzixinxiang"));
				zhengjibean.setFarendaibiao(rs.getString("farendaibiao"));
				zhengjibean.setYouzhengbianma(rs.getString("youzhengbianma"));
				zhengjibean.setLianxi(rs.getString("lianxi"));
				zhengjibean.setDianhua(rs.getString("dianhua"));
				zhengjibean.setShouji(rs.getString("shouji"));
				zhengjibean.setChuangzhen(rs.getString("chuangzhen"));
				zhengjibean.setJigoushuxing(rs.getString("jigoushuxing"));
				zhengjibean.setJigoujianjie(rs.getString("jigoujianjie"));
				zhengjibean.setJishuxuqiuname(rs.getString("jishuxuqiuname"));
				zhengjibean.setXuqiuqianyear(rs.getString("xuqiuqianyear"));
				zhengjibean.setXuqiuhouyear(rs.getString("xuqiuhouyear"));
				zhengjibean.setXuqiugaishu(rs.getString("xuqiugaishu"));
				zhengjibean.setGuanjian1(rs.getString("guanjian1"));
				zhengjibean.setGuanjian2(rs.getString("guanjian2"));
				zhengjibean.setGuanjian3(rs.getString("guanjian3"));
				zhengjibean.setGuanjian4(rs.getString("guanjian4"));
				zhengjibean.setGuanjian5(rs.getString("guanjian5"));
				zhengjibean.setJine(rs.getString("jine"));
				zhengjibean.setXuqiujiejuefangshi(rs.getString("xuqiujiejuefangshi"));
				zhengjibean.setHezuodanwei(rs.getString("hezuodanwei"));
				zhengjibean.setKejihuodongleixing(rs.getString("kejihuodongleixing"));
				zhengjibean.setXuekenfenlei(rs.getString("xuekenfenlei"));
				zhengjibean.setTwoxueke(rs.getString("twoxueke"));
				zhengjibean.setLingyu(rs.getString("lingyu"));
				zhengjibean.setHangye(rs.getString("hangye"));
				zhengjibean.setStatus(StringUtil.StringToInt(rs.getString("status")));
				zhengjibean.setCreatedate(rs.getString("createdate"));
				zhengjibeanlist.add(zhengjibean);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.close(rs,state, conn);
		}
		return zhengjibeanlist;
	}
	public Zhengjibean searchneed(int id)
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		ResultSet rs=null;
		String sql="select * from zhengji where id='"+id+"'";
		Zhengjibean zhengjibean=new Zhengjibean();;
		try
		{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			if(rs.next())
			{
				zhengjibean.setId(rs.getInt("id"));
				zhengjibean.setUserid(rs.getInt("userid"));
				zhengjibean.setJiname(rs.getString("jiname"));
				zhengjibean.setGuikou(rs.getString("guikou"));
				zhengjibean.setTongxundizhi(rs.getString("tongxundizhi"));
				zhengjibean.setSuozaidiyu(rs.getString("suozaidiyu"));
				zhengjibean.setWangzhi(rs.getString("wangzhi"));
				zhengjibean.setDianzixinxiang(rs.getString("dianzixinxiang"));
				zhengjibean.setFarendaibiao(rs.getString("farendaibiao"));
				zhengjibean.setYouzhengbianma(rs.getString("youzhengbianma"));
				zhengjibean.setLianxi(rs.getString("lianxi"));
				zhengjibean.setDianhua(rs.getString("dianhua"));
				zhengjibean.setShouji(rs.getString("shouji"));
				zhengjibean.setChuangzhen(rs.getString("chuangzhen"));
				zhengjibean.setJigoushuxing(rs.getString("jigoushuxing"));
				zhengjibean.setJigoujianjie(rs.getString("jigoujianjie"));
				zhengjibean.setJishuxuqiuname(rs.getString("jishuxuqiuname"));
				zhengjibean.setXuqiuqianyear(rs.getString("xuqiuqianyear"));
				zhengjibean.setXuqiuhouyear(rs.getString("xuqiuhouyear"));
				zhengjibean.setXuqiugaishu(rs.getString("xuqiugaishu"));
				zhengjibean.setGuanjian1(rs.getString("guanjian1"));
				zhengjibean.setGuanjian2(rs.getString("guanjian2"));
				zhengjibean.setGuanjian3(rs.getString("guanjian3"));
				zhengjibean.setGuanjian4(rs.getString("guanjian4"));
				zhengjibean.setGuanjian5(rs.getString("guanjian5"));
				zhengjibean.setJine(rs.getString("jine"));
				zhengjibean.setXuqiujiejuefangshi(rs.getString("xuqiujiejuefangshi"));
				zhengjibean.setHezuodanwei(rs.getString("hezuodanwei"));
				zhengjibean.setKejihuodongleixing(rs.getString("kejihuodongleixing"));
				zhengjibean.setXuekenfenlei(rs.getString("xuekenfenlei"));
				zhengjibean.setTwoxueke(rs.getString("twoxueke"));
				zhengjibean.setLingyu(rs.getString("lingyu"));
				zhengjibean.setHangye(rs.getString("hangye"));
				zhengjibean.setStatus(StringUtil.StringToInt(rs.getString("status")));
				zhengjibean.setCreatedate(rs.getString("createdate"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.close(rs,state, conn);
		}
		return zhengjibean;
	}
	public void zhengjishenehe(int status,int id)
	{
		Connection conn=DBUtil.getConn();
		Statement state=null;
		String sql="update zhengji set status='"+status+"' where id='"+id+"'";
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
