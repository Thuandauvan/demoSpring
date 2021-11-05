package com.laptrinhjavaweb.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO extends AbstractDTO<UserDTO>{
	
	private String userName;
	
	private String email;
	

	private String fullName;

	private String password;
	
	private int status;
	private List<RoleDTO> roles;
	
}
