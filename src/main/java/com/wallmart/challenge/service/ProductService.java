package com.wallmart.challenge.service;

import java.util.List;

import com.wallmart.challenge.dto.ProductDTO;

public interface ProductService {
    
    /**
     * Gets the product.
     *
     * @param id the id
     * @return the product
     */
    List<ProductDTO> getProduct(String id);
}
