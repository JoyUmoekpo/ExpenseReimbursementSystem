package com.joy.ers.handlers;

import java.util.List;

import com.joy.ers.entities.Employee;
import com.joy.ers.entities.Reimbursement;
import io.javalin.http.Handler;

public class EmployeeController {
	
	public static Handler login = ctx -> {
		Employee employeeObject = ctx.bodyAsClass(Employee.class);
		Employee login = login(employeeObject);
		ctx.sessionAttribute("SA", login.getId());
		ctx.json(login);
	};

	public static Handler getAllEmployees = ctx -> {
		List<Employee> eList = getAllEmployees();
		ctx.json(eList);
	};

	public static Handler getEmployeeById = ctx -> {
		int emp = Integer.parseInt(ctx.pathParam("id"));
		List<Employee> eList = getEmployeeById(emp);
		if (eList.size() == 0) {
			ctx.status(404);

		} else {
			ctx.json(eList);
			ctx.status(200);
		}
	};

	public static Handler getAllReimbursements = ctx -> {
		List<Reimbursement> rList = getAllReimbursements();
		ctx.json(rList);
	};

	public static Handler createReimbursement = ctx -> {
		int SA = ctx.sessionAttribute("SA");
		System.out.println(SA);
		Reimbursement reimbursement = ctx.bodyAsClass(Reimbursement.class);
		if (createReimbursement(reimbursement, SA)) {
			ctx.status(201);
		} else {
			ctx.status(404);
		}
	};

	public static Handler getReimbursementById = ctx -> {
		int emp = Integer.parseInt(ctx.pathParam("id"));
		List<Reimbursement> rList =getReimbursementById(emp);
		if (rList.size() == 0) {
			ctx.status(404);

		} else {
			ctx.json(rList);
			ctx.status(200);
		}
	};

	private static Employee login(Employee employeeObject) {
		// TODO Auto-generated method stub
		return null;
	}

	private static List<Reimbursement> getReimbursementById(int emp) {
		// TODO Auto-generated method stub
		return null;
	}

	private static boolean createReimbursement(Reimbursement reimbursement, int sA) {
		// TODO Auto-generated method stub
		return false;
	}

	private static List<Reimbursement> getAllReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

	private static List<Employee> getEmployeeById(int emp) {
		// TODO Auto-generated method stub
		return null;
	}

	private static List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}