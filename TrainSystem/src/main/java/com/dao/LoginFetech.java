package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginFetech {
	public boolean credentials(String usr, String pass) throws Exception {
		Class.forName("org.postgresql.Driver");
		Connection cn = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training",
				"plf_training_admin", "pff123");

		String sql = "select * from i197_users where username=? and password=?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, usr);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return true;
		} else {
			return false;
		}
	}
}
