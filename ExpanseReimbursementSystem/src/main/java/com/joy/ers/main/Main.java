package com.joy.ers.main;

import com.joy.ers.handlers.EmployeeController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {

	public static void main(String[] args) {
		Javalin app = Javalin.create(ctx -> {
			ctx.enableCorsForAllOrigins();
			ctx.addStaticFiles("web", Location.CLASSPATH);
		}).start();

		app.before(ctx -> ctx.header("Access-Control-Allow-Credentials", "true"));
		app.post("/login", EmployeeController.login);
		app.get("/employees", EmployeeController.getAllEmployees);
		app.get("/employees/{id}", EmployeeController.getEmployeeById);
		app.get("/reimbursements", EmployeeController.getAllReimbursements);
		app.post("/reimbursements", EmployeeController.createReimbursement);
		app.get("/reimbursements/{id}", EmployeeController.getReimbursementById);
	}
}
