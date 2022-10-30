package com.ers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ers.pojo.Reimbursement;
import com.ers.pojo.Response;
import com.ers.pojo.User;
import com.ers.service.IReimburesementSrv;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "reimbursement")
public class ReimbursementController {

	@Autowired
	private IReimburesementSrv reimburesementSrv;
//validate Login , input:User object with userName and password, output:User object with full details

	
	
	@PostMapping(value = "/new")
	public ResponseEntity<String> applyForNewReimbursement(@RequestBody Reimbursement rObj){
		String result = reimburesementSrv.applyForNewReimbursement(rObj);
		return ResponseEntity.ok(result);
	}
	@GetMapping(value = "/all/{userId}")
	public Response getAllRembursements(@PathVariable int userId) {
		List<Reimbursement> reimbursements = reimburesementSrv.getReimbursements(userId);
		return new Response(200,reimbursements);
		
	}
	
	@GetMapping(value="/all")
	public Response getAllReimbursement(){
		List<Reimbursement> allReimburesments = reimburesementSrv.getAllReimbursement();
		Response response = new Response(200,allReimburesments);
		return response;
	}
	//resolve reimbursement
	@PutMapping(value="/resolve")
	public Response resolveReimbursement(@RequestBody Reimbursement rObj) {
		String update = reimburesementSrv.updateReimbursement(rObj);
		return new Response(200,update);
	}
	
	
}