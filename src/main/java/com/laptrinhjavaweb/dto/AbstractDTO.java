package com.laptrinhjavaweb.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AbstractDTO<T>{
	
	private Long id;
	
	private Timestamp createdDate;
	
	private Timestamp modifiedDate;
	
	private String createdBy;
	
	private String modifiedBy;
}
