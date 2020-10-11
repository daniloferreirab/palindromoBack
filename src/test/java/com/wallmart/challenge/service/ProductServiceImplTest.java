package com.wallmart.challenge.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.util.ReflectionTestUtils;

import com.wallmart.challenge.dto.ProductDTO;
import com.wallmart.challenge.entity.Product;
import com.wallmart.challenge.mapper.ProductMapper;
import com.wallmart.challenge.repository.ProductRepository;
import com.wallmart.challenge.serviceImpl.ProductServiceImpl;



@RunWith(JUnitPlatform.class)
public class ProductServiceImplTest {

    
    @InjectMocks
    private ProductService service = new ProductServiceImpl();
    
    @Mock
    ProductRepository repository;
    
    @Mock
    ProductMapper mapper;
    
    @Value("${discount.palindromo}")
    private Integer percentageDiscount;
    
    private final EasyRandom easyRandom = new EasyRandom();
    
    
    @BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(service, "percentageDiscount", 20);
	}
    
   
    @Test
    public void getProductPalindromoTest(){
	List<Product> product =  easyRandom.objects(Product.class, 5).collect(Collectors.toList());
	List<ProductDTO> productDto = (List<ProductDTO>) easyRandom.objects(ProductDTO.class, 5).collect(Collectors.toList());
	Mockito.when(repository.findAllById(Mockito.anyInt())).thenReturn(product);
	Mockito.when(mapper.productListToProductDTOList(Mockito.anyList())).thenReturn(productDto);
	
	List<ProductDTO> result = service.getProduct("121");
	assertThat(result).isNotEmpty();
    }
    
   
    @Test
    public void getProductNotPalindromoTest(){
	List<Product> product =  easyRandom.objects(Product.class, 5).collect(Collectors.toList());
	List<ProductDTO> productDto = (List<ProductDTO>) easyRandom.objects(ProductDTO.class, 5).collect(Collectors.toList());
	Mockito.when(repository.findAllById(Mockito.anyInt())).thenReturn(product);
	Mockito.when(mapper.productListToProductDTOList(Mockito.anyList())).thenReturn(productDto);
	
	List<ProductDTO> result = service.getProduct("1212");
	assertThat(result).isNotEmpty();
    }
    
    
    @Test
    public void getProductPalindromoTest2(){
	List<Product> product =  easyRandom.objects(Product.class, 5).collect(Collectors.toList());
	List<ProductDTO> productDto = (List<ProductDTO>) easyRandom.objects(ProductDTO.class, 5).collect(Collectors.toList());
	Mockito.when(repository.findAll()).thenReturn(product);
	Mockito.when(mapper.productListToProductDTOList(Mockito.anyList())).thenReturn(productDto);
	
	List<ProductDTO> result = service.getProduct("ass");
	assertThat(result).isNotEmpty();
    }
    
    
    @Test
    public void getProductNotPalindromoTest2(){
	List<Product> product =  easyRandom.objects(Product.class, 5).collect(Collectors.toList());
	List<ProductDTO> productDto = (List<ProductDTO>) easyRandom.objects(ProductDTO.class, 5).collect(Collectors.toList());
	Mockito.when(repository.findAll()).thenReturn(product);
	Mockito.when(mapper.productListToProductDTOList(Mockito.anyList())).thenReturn(productDto);
	
	List<ProductDTO> result = service.getProduct("assa");
	assertThat(result).isNotEmpty();
    }
    
    @Test
    public void getProductShortTest2(){
	List<Product> product =  easyRandom.objects(Product.class, 5).collect(Collectors.toList());
	List<ProductDTO> productDto = (List<ProductDTO>) easyRandom.objects(ProductDTO.class, 5).collect(Collectors.toList());
	Mockito.when(repository.findAll()).thenReturn(product);
	Mockito.when(mapper.productListToProductDTOList(Mockito.anyList())).thenReturn(productDto);
	
	List<ProductDTO> result = service.getProduct("as");
	assertThat(result).isEmpty();
    }
}
