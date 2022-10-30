package com.ers.repo;

import com.ers.pojo.User;


public interface IUserRepo {
	

	int createNewUser(User uObj);

	int updateUser(User user);

	int deleteUser(int userId);

	User loginUser(String userName, String pwd);
}
