package com.wallmart.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallmart.challenge.dto.ProductDTO;
import com.wallmart.challenge.service.ProductService;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    
    @Autowired
    private ProductService service;
    
    /**
     * Gets the product.
     *
     * @param word the word
     * @return the product
     */
    @GetMapping(path = "/search/{word}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDTO>> getProduct(@PathVariable String word){
	List<ProductDTO> producto = service.getProduct(word);
	return new ResponseEntity<>(producto, HttpStatus.OK);
    }
}
