package com.joy.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.joy.ers.entities.Employee;
import com.joy.ers.utils.ConnectionUtils;

public class EmployeeDAOPostgres implements EmployeeDAO {
	static Connection conn = ConnectionUtils.getInstance();

	@Override
	public Employee login(Employee employeeObject) {
		// TODO Auto-generated method stub
		Employee Emp = new Employee();
		try {
			PreparedStatement ptsmt = conn.prepareStatement("select * from employees");
			ResultSet rs = ptsmt.executeQuery();
			String employeUsername = employeeObject.getUsername();
			String employeePassword = employeeObject.getPassword();

			while (rs.next()) {
				int id = rs.getInt("id");
				String password = rs.getString("password");
				String username = rs.getString("username");
				if (employeUsername.equals(username) && employeePassword.equals(password)) {
					Emp.setId(id);
					Emp.setUsername(employeUsername);
					Emp.setPass(employeePassword);
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		String Emp = "select * from employees";
		ArrayList<Employee> eList = new ArrayList<Employee>();
		Employee e;
		try {
			PreparedStatement ptsmt = conn.prepareStatement(Emp);
			ResultSet rs = ptsmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String password = rs.getString("password");
				String username = rs.getString("username");
				e = new Employee(id, username, password);
				eList.add(e);

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return eList;
	}

	@Override
	public List<Employee> getEmployeeById(int emp) {
		// TODO Auto-generated method stub
		String Emp = "select * from employees where id=?";
		ArrayList<Employee> eList = new ArrayList<Employee>();
		Employee e;
		try {
			PreparedStatement ptsmt = conn.prepareStatement(Emp);
			ptsmt.setInt(1, emp);
			ResultSet rs = ptsmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String password = rs.getString("password");
				String username = rs.getString("username");
				e = new Employee(id, username, password);
				eList.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return eList;
	}

}