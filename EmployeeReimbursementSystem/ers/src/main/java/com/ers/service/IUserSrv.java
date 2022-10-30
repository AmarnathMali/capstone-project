package com.ers.service;

import org.springframework.stereotype.Service;

import com.ers.pojo.User;

public interface IUserSrv {

	String createNewUser(User uObj);

	String updateUser(User user);

	String deleteUser(int userId);

	User loginUser(String userName,String pwd);
}
