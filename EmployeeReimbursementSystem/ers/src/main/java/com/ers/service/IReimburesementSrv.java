package com.ers.service;

import java.util.List;

import com.ers.pojo.Reimbursement;
import com.ers.pojo.User;

public interface IReimburesementSrv {


	String applyForNewReimbursement(Reimbursement rObj);
	List<Reimbursement> getReimbursements(int userId);
	List<Reimbursement> getAllReimbursement();
	String updateReimbursement(Reimbursement rObj);
}
