package com.ers.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ers.pojo.Response;
import com.ers.pojo.User;
import com.ers.service.IUserSrv;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private IUserSrv userSrv;
	
	@PostMapping(value = "/new")
	public Response createNewUser(@RequestBody User uObj) {
		String newUser = userSrv.createNewUser(uObj);
		return new Response(200,newUser);
	}
	@PutMapping(value="/update")
    public Response updateUser(@RequestBody User user) {
    	String updateUser = userSrv.updateUser(user);
		return new Response(200,updateUser);
    }
	@DeleteMapping(value = "/delete/{userId}")
	public Response deleteUser(@PathVariable int userId) {
		String deleteUser = userSrv.deleteUser(userId);
		return new Response(200,deleteUser);
	}
	@PostMapping(value = "/login")
	public Response loginUser(@RequestBody User user) {
		User loginUser = userSrv.loginUser(user.getUserName(),user.getPwd());
		System.out.println(loginUser);
		return new Response(200,loginUser);
		
	}

}
