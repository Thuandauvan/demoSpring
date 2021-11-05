package com.laptrinhjavaweb.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product extends Abstract {
	
	@Column(name="image")
	private String image;
	
	@Column(name="title", columnDefinition = "TEXT")
	private String title;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="shortdescription", columnDefinition = "TEXT")
	private String shortDescription;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<Comment> comments;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "product")
	private CartItem cartItem;

}
