package com.wallmart.challenge.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wallmart.challenge.dto.ProductDTO;
import com.wallmart.challenge.entity.Product;
import com.wallmart.challenge.mapper.ProductMapper;
import com.wallmart.challenge.repository.ProductRepository;
import com.wallmart.challenge.service.ProductService;
import com.wallmart.challenge.utils.Utility;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired 
    ProductRepository repository;
    
    @Autowired
    ProductMapper mapper;
    
    @Value("${discount.palindromo}")
    private Integer percentageDiscount;
    
    private static final Logger log = Logger.getLogger(ProductServiceImpl.class.getName());

    /**
     * Gets the product.
     *
     * @param word the word
     * @return the product
     */
    @Override
    public List<ProductDTO> getProduct(String word) {
	boolean isNumber = false;
	Integer valueInt = 0;
	List<ProductDTO> pDtoList = new ArrayList<>();
	try {
	    valueInt = Integer.parseInt(word);
	    isNumber = true;
	} catch (NumberFormatException e) {
	    log.info("word search is string");
	}
	if(isNumber) {
	    List<Product> product = repository.findAllById(valueInt);
	    pDtoList = mapper.productListToProductDTOList(product);
	    if(Utility.isPalindrome(word)) {
		 calculateDiscount(pDtoList);
	    }
	   
	}else {
		if(word.length() >= 3 ) {
		    List<Product> products = repository.findAll();
		    
		    pDtoList.addAll(findWordInBrandAndDescription(products, word));
		    
		    if(Utility.isPalindrome(word)) {
			 calculateDiscount(pDtoList);
		    }
		}else {
		    log.info("word lenght is very short");
		}
	}
	
	return pDtoList;
    }
    
    /**
     * Find word in brand and description.
     *
     * @param products the products
     * @param word the word
     * @return the sets the
     */
    private Set<ProductDTO> findWordInBrandAndDescription(List<Product> products, String word){
	Set<ProductDTO> productFiltered = new HashSet<>();

	List<Product> filterByBrand = products.stream().filter(p -> p.getBrand().toLowerCase().contains(word.toLowerCase())).collect(Collectors.toList());
	List<Product> filterByDescription = products.stream().filter(p -> p.getDescription().toLowerCase().contains(word.toLowerCase())).collect(Collectors.toList());
	
	productFiltered.addAll( mapper.productListToProductDTOList(filterByBrand));
	productFiltered.addAll( mapper.productListToProductDTOList(filterByDescription));
	
	return productFiltered;
    }
    
    /**
     * Calculate discount.
     *
     * @param products the products
     */
    private void calculateDiscount(List<ProductDTO> products){	
	for(ProductDTO pDto: products) {
	    Integer discount = ((pDto.getPrice() * percentageDiscount) / 100);
	    Integer dicountApply = pDto.getPrice() - discount;
	    pDto.setOriginalPrice(pDto.getPrice());
	    pDto.setPrice(dicountApply); 
	    pDto.setPercentajeDiscount(percentageDiscount);
	}

    }

}
