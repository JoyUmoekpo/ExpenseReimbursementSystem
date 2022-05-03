package com.joy.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.joy.ers.entities.Reimbursement;
import com.joy.ers.utils.ConnectionUtils;

public class ReimbursementDAOPostgres implements ReimbursementDAO {

	static Connection conn = ConnectionUtils.getInstance();

	@Override
	public List<Reimbursement> getAllReimbursements() {
		// TODO Auto-generated method stub
		String Reimburse = "select * from reimbursements";
		ArrayList<Reimbursement> rList = new ArrayList<Reimbursement>();
		Reimbursement r;
		try {
			PreparedStatement ptsmt = conn.prepareStatement(Reimburse);
			ResultSet rs = ptsmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int employeeID = rs.getInt("employee_id");
				int managerID = rs.getInt("manager_id");
				r = new Reimbursement(id, employeeID, managerID);
				rList.add(r);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return rList;
	}

	@Override
	public boolean createReimbursement(Reimbursement reimbursement, int SA) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ptsmt = conn
					.prepareStatement("INSERT into reimbursements values(DEFAULT,?, null)");
			ptsmt.setInt(1, SA);
			ptsmt.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Reimbursement> getReimbursementById(int REM) {
		// TODO Auto-generated method stub
		String Reimburse = "select * from reimbursements where id=?";
		ArrayList<Reimbursement> rList = new ArrayList<Reimbursement>();
		Reimbursement r;
		try {
			PreparedStatement ptsmt = conn.prepareStatement(Reimburse);
			ptsmt.setInt(1, REM);
			ResultSet rs = ptsmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int employeeID = rs.getInt("employee_id");
				int managerID = rs.getInt("manager_id");
				r = new Reimbursement(id, employeeID, managerID);
				rList.add(r);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return rList;
	}

	@Override
	public List<Reimbursement> getReimbursementsByEmployee(int REM) {
		// TODO Auto-generated method stub
		String Reimburse = "select * from reimbursements where employee_id=?";
		ArrayList<Reimbursement> rList = new ArrayList<Reimbursement>();
		Reimbursement r;
		try {
			PreparedStatement ptsmt = conn.prepareStatement(Reimburse);
			ptsmt.setInt(1, REM);
			ResultSet rs = ptsmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int employeeID = rs.getInt("employee_id");
				int managerID = rs.getInt("manager_id");
				r = new Reimbursement(id, employeeID, managerID);
				rList.add(r);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return rList;
	}

}