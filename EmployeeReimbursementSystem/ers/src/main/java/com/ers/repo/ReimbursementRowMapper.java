package com.ers.repo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ers.pojo.DateConversion;
import com.ers.pojo.Reimbursement;

public class ReimbursementRowMapper implements RowMapper<Reimbursement>{

	@Override
	public Reimbursement mapRow(ResultSet rs, int rowNum) throws SQLException {
		Reimbursement reimbursement = new Reimbursement();
		
		
		reimbursement.setReimbursementId(rs.getInt("reimbursementId"));
		reimbursement.setUserId(rs.getInt("userId"));
		reimbursement.setReason(rs.getString("reason"));
		reimbursement.setAmount(rs.getInt("amount"));
		reimbursement.setStatus(rs.getString("status"));
		
		if(rs.getDate("raisedOn")!= null) {
			reimbursement.setRaisedOn(DateConversion.convertDateFromSqlToUtil(rs.getDate(6)));
		}
		if(rs.getString("userName") != null) {
			reimbursement.setUserName(rs.getString("userName"));
		}
		
		return reimbursement;
	}

}
