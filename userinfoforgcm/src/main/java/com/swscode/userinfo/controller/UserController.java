package com.swscode.userinfo.controller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swscode.userinfo.dto.UserDTO;
import com.swscode.userinfo.entity.User;
import com.swscode.userinfo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/fetechAllUsers")
	public ResponseEntity<List<UserDTO>> fetchAllUSers(){
		
		List<UserDTO> userDTOList = userService.findAllUsers();
		
		return new ResponseEntity<List<UserDTO>>(userDTOList,null, HttpStatus.SC_OK);
		
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<UserDTO> addUser(@RequestBody User user){
		
		System.out.println("inside addUser");
		UserDTO userAdded = userService.addUser(user);
		return new ResponseEntity<UserDTO>(userAdded,null, HttpStatus.SC_CREATED );
		
	}
	
	@GetMapping("/fetchUser/{userId}")
	public ResponseEntity<UserDTO> findUserById(@PathVariable Integer userId){
		
		UserDTO userFound = userService.findUserById(userId);
		if(null!=userFound) {
			return new ResponseEntity<UserDTO>(userFound, null, HttpStatus.SC_OK);
			
		}
		else {
			return new ResponseEntity<UserDTO>(userFound, null, HttpStatus.SC_NOT_FOUND);
		}
		
		
	}
	

}
