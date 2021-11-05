package com.laptrinhjavaweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO extends AbstractDTO<ProductDTO>{
	
	private String image;
	private String title;
	private Double price;
	private String shortDescription;
	private Long categoryId;
}
