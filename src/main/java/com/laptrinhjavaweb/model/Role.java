package com.laptrinhjavaweb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role extends Abstract{
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();
}
