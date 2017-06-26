package com.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil
{
	
	Connection con = null;
	
	public DBUtil() throws Exception
	{
		con = 	DBManager.getConn();
	}
	

	public ResultSet exeQuery(String sql) throws SQLException
	{
		Statement stat=con.createStatement();
		ResultSet rs=stat.executeQuery(sql);
		return rs;
	}
	
	
	public ResultSet exeQuery2(String sql,String... args) throws SQLException
	{
		PreparedStatement stat=con.prepareStatement(sql);
		for(int i=0;i<args.length;i++)
		{
			stat.setString(i+1, args[i]);
		}
		ResultSet rs=stat.executeQuery();
		return rs;
	}
	
	public boolean execute(String sql) throws SQLException
	{
		Statement stat=con.createStatement();
		int n= stat.executeUpdate(sql);
		if(n>0) return true;
		else
			 return false;
	}
	
	public boolean execute2(String sql,Object... args) throws SQLException
	{
		 PreparedStatement stat = con.prepareStatement(sql);
		 for(int i=0;i<args.length;i++)
		 {
			 stat.setObject(i+1, args[i]);
		 }
		int n = stat.executeUpdate();
		System.out.println(n);
		if(n>0) return true;
		else
			 return false;
	}
	
	public void close() throws SQLException
	{
		if (con!=null)
			DBManager.close(con);
	}


	public ResultSet exeQuery2(String sql, int id) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stat=con.prepareStatement(sql);
		
		stat.setInt(1, id);
		
		ResultSet rs=stat.executeQuery();
		return rs;
	}
	
}
