package com.laptrinhjavaweb.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name="cart" )
public class Cart extends Abstract {
	
	@Column(name = "total_product")
	private Integer totalProduct;
	
	@Column(name = "total_price")
	private Integer totalPrice;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	private List<CartItem> cartItems;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "cart")
    private User user;
}
