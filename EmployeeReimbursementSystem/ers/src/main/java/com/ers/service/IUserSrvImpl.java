package com.ers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ers.pojo.User;
import com.ers.repo.IUserRepo;

@Service
public class IUserSrvImpl implements IUserSrv{
	
	@Autowired
	private IUserRepo userRepo;

	@Override
	public String createNewUser(User uObj) {
		int createNewUser = userRepo.createNewUser(uObj);
		if(createNewUser != 0) {
			return "user created successfully";
		}else {
			return "user not created";
		}

	}

	@Override
	public String updateUser(User user) {
		// TODO Auto-generated method stub
		int updateUser = userRepo.updateUser(user);
		if(updateUser != 0) {
			return "user has been updated";
		}else {
			return "not updated";
		}
		
	}

	@Override
	public String deleteUser(int userId) {
		int deleteUser = userRepo.deleteUser(userId);
		if(deleteUser != 0) {
			return "user deleted succesfully";
		}else {
			return "user not deleted";
		}
	
	}

	
	@Override
	public User loginUser(String userName, String pwd) {
		User loginUser = userRepo.loginUser(userName,pwd);
		return loginUser;
	}

}
