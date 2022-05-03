package com.joy.ers.dao;

import java.util.List;

import com.joy.ers.entities.Reimbursement;

public interface ReimbursementDAO {
	List<Reimbursement> getAllReimbursements();

	List<Reimbursement> getReimbursementById(int REM);

	List<Reimbursement> getReimbursementsByEmployee(int REM);

	boolean createReimbursement(Reimbursement reimbursement, int SA);
}
