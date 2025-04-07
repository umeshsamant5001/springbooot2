package com.swscode.userinfo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swscode.userinfo.dto.UserDTO;
import com.swscode.userinfo.entity.User;
import com.swscode.userinfo.mapper.UserMapper;
import com.swscode.userinfo.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	public List<UserDTO> findAllUsers(){
		
		List<UserDTO> userDTOList = userRepo.findAll().stream().map(user -> UserMapper.INSTANCE.mapUserToUserDTO(user)).collect(Collectors.toList());;
		return userDTOList;
	}
	
	public UserDTO findUserById(Integer userId) {
		
		Optional<User> userFound = userRepo.findById(userId);
		
		if(userFound.isPresent()) {
			return UserMapper.INSTANCE.mapUserToUserDTO(userFound.get());
		}
		
		return null;
	}
	
	public UserDTO addUser(User user) {
		User savedUser = userRepo.save(user);
		return  UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
				
		
	}
	

}
