package com.facebook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.facebook.entity.FacebookUser;
import com.facebook.utility.DatabaseConnection;

public class FacebookDao implements FacebookDaoInterface {

//	private static FacebookUser fuser[];
//	static {
//		fuser = new FacebookUser[10];
//	}

	@Override
	public int createProfileDao(FacebookUser fu) {
		int i = 0;
		// TODO Auto-generated method stub
//		for(int i = 0;i < fuser.length; i++) {
//			if(fuser[i] == null) {
//				fuser[i] = fu;
//				break;
//			}
//		}
//		if(fuser.length > 0) {
//			return 1;
//		}
//		else {
//			return 0;
//		}
//		
		try {
			// step 1 : load driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step 2 : create connection with database
			Connection con = DriverManager.getConnection("jdbc:mysql:///revaturechennai", "root", "root");

			// step 3 : Create dynamic query
			PreparedStatement ps = con.prepareStatement("insert into facebookuser values(?,?,?,?)");

			// step 4 : execute query

			ps.setString(1, fu.getName());
			ps.setString(2, fu.getPwd());
			ps.setString(3, fu.getEmail());
			ps.setString(4, fu.getAddress());
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public FacebookUser viewProfileDao(FacebookUser fu) {
		// TODO Auto-generated method stub
		FacebookUser f2 = null;
		try {

			//Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:mysql:///revaturechennai", "root", "root");
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from facebookuser where email=?");
			ps.setString(1, fu.getEmail());

			ResultSet res = ps.executeQuery();
			while (res.next()) {
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a = res.getString(4);

				f2 = new FacebookUser();
				f2.setName(n);
				f2.setPwd(p);
				f2.setEmail(e);
				f2.setAddress(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f2;

	}

	@Override
	public List<FacebookUser> viewAllProfileDao() {
		// TODO Auto-generated method stub
		List<FacebookUser> fu = new ArrayList<FacebookUser>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///revaturechennai", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from facebookuser");
			//Connection con=DatabaseConnection.getConnection();
			//Statement ps = con.createStatement();
			//CallabaleStatement ps = con.prepareCall("{call anusha}");
			//Resultset res = ps.executeQuery();
			ResultSet res = ps.executeQuery("select * from facebookuser");
			while (res.next()) {
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a = res.getString(4);

				FacebookUser f1 = new FacebookUser();
				f1.setName(n);
				f1.setPwd(p);
				f1.setEmail(e);
				f1.setAddress(a);

				fu.add(f1);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return fu;
	}

	@Override
	public FacebookUser searchProfileDao(FacebookUser fu) {
		FacebookUser f2 = null;
		// TODO Auto-generated method stub
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///revaturechennai", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from facebookuser where email=?");
			ps.setString(1, fu.getEmail());

			ResultSet res = ps.executeQuery();
			while (res.next()) {
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a = res.getString(4);

				f2 = new FacebookUser();
				f2.setName(n);
				f2.setPwd(p);
				f2.setEmail(e);
				f2.setAddress(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f2;

	}

	@Override
	public int editProfileDao(FacebookUser fu) {
		int i=0;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql:///revaturechennai","root","root");
		PreparedStatement ps=con.prepareStatement("update facebookuser set pwd=?, address=? where email=?");
		ps.setString(1, fu.getPwd());
		ps.setString(2, fu.getAddress());
		ps.setString(3, fu.getEmail());
		i=ps.executeUpdate();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteProfileDao(FacebookUser fu) {
		// TODO Auto-generated method stub
		int i = 0;
		// TODO Auto-generated method stub
		try {

			Connection con=DatabaseConnection.getConnection();
			//PreparedStatement ps = con.prepareStatement("delete from facebookuser where email=?");
			Statement ps = con.createStatement();
			
           // i = ps.exectureUpdate();
			i = ps.executeUpdate("delete from facebookuser where email='"+fu.getEmail()+"'");
			//ps.setString(1, fu.getEmail());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	@Override
	public FacebookUser loginProfileDao(FacebookUser fu) {
		FacebookUser f2 = null;
		// TODO Auto-generated method stub
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///revaturechennai", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from facebookuser where email=? and pwd=?");
			ps.setString(1, fu.getEmail());
			ps.setString(2, fu.getPwd());

			ResultSet res = ps.executeQuery();
			while (res.next()) {
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a = res.getString(4);

				f2 = new FacebookUser();
				f2.setName(n);
				f2.setPwd(p);
				f2.setEmail(e);
				f2.setAddress(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f2;

	}
}