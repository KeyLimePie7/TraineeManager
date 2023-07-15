package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Trainee;
import com.util.DBUtil;

public class TraineeDao {
	public Trainee searchTrainee(int empId) {
		Trainee result=null;
		try {
			Connection cn=DBUtil.createConnection();
			PreparedStatement ps=cn.prepareStatement("SELECT * FROM Trainee WHERE emp_id=?");
			ps.setInt(1, empId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				result=new Trainee();
				result.setEmpId(rs.getInt("emp_id"));
				result.setName(rs.getString("name"));
				result.setLgName(rs.getString("lg_name"));
				result.setRating(rs.getInt("rating"));
				result.setFeedback(rs.getString("feedback"));
			}
			DBUtil.closeAllConnection(cn, ps, rs);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public boolean deleteTrainee(int empId) {
		boolean result=false;
		try {
			Connection cn=DBUtil.createConnection();
			PreparedStatement ps=cn.prepareStatement("DELETE FROM Trainee WHERE emp_id=?");
			ps.setInt(1, empId);
			int t=ps.executeUpdate();
			if(t>0) {
				result=true;
			}
			DBUtil.closeAllConnection(cn, ps, null);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}
