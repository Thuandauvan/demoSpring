package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.model.User;

@Service
public class UserConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
    public User convertToEntity(UserDTO userDTO) {
		
    	User userEntity = modelMapper.map(userDTO, User.class);
		
		return userEntity;
	}
    
    public UserDTO convertToDTO(User userEntity) {
       
    	UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
		
		return userDTO;
	}
}
