package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.model.Product;

@Service
public class ProductConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
    public Product convertToEntity(ProductDTO productDTO) {
		
    	Product productEntity = modelMapper.map(productDTO, Product.class);
		
		return productEntity;
	}
    
    public ProductDTO convertToDTO(Product productEntity) {
		
    	ProductDTO productDTO = modelMapper.map(productEntity, ProductDTO.class);
		
		return productDTO;
	}
}
