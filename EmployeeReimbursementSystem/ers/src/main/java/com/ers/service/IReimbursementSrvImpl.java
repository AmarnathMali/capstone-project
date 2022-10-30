package com.ers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ers.pojo.Reimbursement;
import com.ers.pojo.User;
import com.ers.repo.IReimbursementRepo;

@Service
public class IReimbursementSrvImpl implements IReimburesementSrv{

	@Autowired
	private IReimbursementRepo reimbursementRepo;
	
	
	@Override
	public String applyForNewReimbursement(Reimbursement rObj) {
		int result = reimbursementRepo.applyForNewReimbursement(rObj);
		if(result != 0) {
			return "successful";
		}else {
			return "not successful";
		}
	}
	@Override
	public List<Reimbursement> getReimbursements(int userId) {
		// TODO Auto-generated method stub
		List<Reimbursement> reimbursements = reimbursementRepo.getReimbursements(userId);
		return reimbursements;
	}
	@Override
	public List<Reimbursement> getAllReimbursement() {
		// TODO Auto-generated method stub
		List<Reimbursement> allReim = reimbursementRepo.getAllReimbursements();
		return allReim;
	}
	@Override
	public String updateReimbursement(Reimbursement rObj) {
		// TODO Auto-generated method stub
		int update = reimbursementRepo.updateReimbursement(rObj);
		if(update != 0) {
			return "success";
		}else {
			return "failure";
		}
		
	}
	
}
