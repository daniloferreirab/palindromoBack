package com.wallmart.challenge.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.wallmart.challenge.dto.ProductDTO;
import com.wallmart.challenge.service.ProductService;

public class ProductControllerTest {
    
    @InjectMocks
    private ProductController controller;
    
    @Mock
    private ProductService service;
    
    private final EasyRandom easyRandom = new EasyRandom();
    
    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void getProductTest() {
	List<ProductDTO> productDto = (List<ProductDTO>) easyRandom.objects(ProductDTO.class, 5).collect(Collectors.toList());
	
	Mockito.when(service.getProduct(Mockito.anyString())).thenReturn(productDto);
	
	ResponseEntity<List<ProductDTO>>  result = controller.getProduct("121");
	 assertThat(result).isNotNull();
    }

}
