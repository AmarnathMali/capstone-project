package com.ers.repo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ers.pojo.DateConversion;
import com.ers.pojo.Reimbursement;
import com.ers.pojo.User;

@Repository
public class IReimbursementRepoImpl implements IReimbursementRepo{

	@Autowired
	 private JdbcTemplate jdbcTemplate;
	

	

	@Override
	public int applyForNewReimbursement(Reimbursement rObj) {
		java.sql.Date dateInSqlFormat = null;
		if(rObj.getRaisedOn()!=null) {
		dateInSqlFormat = new java.sql.Date(rObj.getRaisedOn().getTime());
		}
		String query = "insert into reimbursement_info (userId, reason, amount, status, raisedOn) values (?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(query, new Object[] {rObj.getUserId(), rObj.getReason(), rObj.getAmount(), "PENDING",DateConversion.convertDateFromUtilToSql(new Date())} );
		return result;
		
	}

	

	@Override
	public List<Reimbursement> getReimbursements(int userId) {
		// TODO Auto-generated method stub
		String query = "select r.reimbursementId, r.userId, r.reason, r.amount, r.status,\r\n" + 
				"r.raisedOn, u.userName from reimbursement_info r join user_tab u on r.userid = u.userid and r.userId = ?";
		List<Reimbursement> reim =  jdbcTemplate.query(query, new Object[] {userId},new ReimbursementRowMapper());
		return reim;
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		// TODO Auto-generated method stub
		//String query = "select reimbursementId,r.userId,reason,amount,status,raisedOn,userName from reimbursement_info r inner join user_tab u on r.userId = u.userId";
		String query = "select reimbursementId, r.userId, reason, amount, status, raisedOn, userName from reimbursement_info r join user_tab u  on r.userId = u.userId";
		List<Reimbursement> allReimbursements =  jdbcTemplate.query(query , new ReimbursementRowMapper());
		return allReimbursements;
	}

	@Override
	public int updateReimbursement(Reimbursement rObj) {
		// TODO Auto-generated method stub
		String query = "update reimbursement_info set status=? where reimbursementId=?";
		int update = jdbcTemplate.update(query,new Object[] {rObj.getStatus(), rObj.getReimbursementId()});
		return update;
	}

	

}
