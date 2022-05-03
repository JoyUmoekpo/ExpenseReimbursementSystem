package com.joy.ers.entities;

public class Reimbursement {
	private int id;
	private int empId;
	private int manId;

	public Reimbursement() {
		super();
	}

	public Reimbursement(int id, int empId, int manId) {
		super();
		this.id = id;
		this.empId = empId;
		this.manId = manId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getManId() {
		return manId;
	}

	public void setManId(int manId) {
		this.manId = manId;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", empId=" + empId + ", manId=" + manId + "]";
	}
}