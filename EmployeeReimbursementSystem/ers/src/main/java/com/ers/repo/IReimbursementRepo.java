package com.ers.repo;

import java.util.List;

import com.ers.pojo.Reimbursement;
import com.ers.pojo.User;

public interface IReimbursementRepo {
	
	
	int applyForNewReimbursement(Reimbursement rObj);

	List<Reimbursement> getReimbursements(int userId);

	List<Reimbursement> getAllReimbursements();

	int updateReimbursement(Reimbursement rObj);
}
