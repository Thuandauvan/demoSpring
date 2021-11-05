package com.laptrinhjavaweb.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class Abstract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="createddate")
	@CreatedDate
	private Timestamp createdDate;
	
	@Column(name="modifieddate")
	@LastModifiedDate
	private Timestamp modifiedDate; 
	
	@Column(name="createdby")
	@CreatedBy
	private String createdBy;
	
	@Column(name="modifiedby")
	@LastModifiedBy
	private String modifiedBy;
}
