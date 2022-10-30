package com.ers.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ers.pojo.User;

@Repository
public class IUserRepoImpl implements IUserRepo{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int createNewUser(User uObj) {
		// TODO Auto-generated method stub
		String query = "insert into user_tab (userName,pwd,fName,lName,role,emailId) values(?,?,?,?,?,?)";
		int create = jdbcTemplate.update(query, new Object[] {uObj.getUserName(),uObj.getPwd(),uObj.getfName(),uObj.getlName(),uObj.getRole(),uObj.getEmailId()});
		return create;
	}
	@Override
	public int updateUser(User user) {
	    String query = "update user_tab set userName = ?, pwd = ?, fName=?,lName=?,role=?,emailId=? where userId = ?";
	    int update = jdbcTemplate.update(query,new Object[] {user.getUserName(),user.getPwd(),user.getfName(),user.getlName(),user.getRole(),user.getEmailId(),user.getUserId()});
		return update;
	}
	@Override
	public int deleteUser(int userId) {
		String query = "delete from user_tab where userId = ?";
		int delete = jdbcTemplate.update(query,new Object[] {userId});
		return delete;
	}
	@Override
	public User loginUser(String userName,String pwd) {
		String query ="select * from user_tab where userName= ? and pwd = ?";
		User checkUser = jdbcTemplate.queryForObject(query, new Object[] {userName,pwd},new UserRowMapper());
		
		return checkUser;
	}
	

	
}
