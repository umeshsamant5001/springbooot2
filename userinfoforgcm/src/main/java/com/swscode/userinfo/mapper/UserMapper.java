package com.swscode.userinfo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.swscode.userinfo.dto.UserDTO;
import com.swscode.userinfo.entity.User;

@Mapper
public interface UserMapper {
	
	// Abstarct methods for conversion
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	UserDTO mapUserToUserDTO(User user);
	User mapUserDtoToUser(UserDTO userDTO);

}
