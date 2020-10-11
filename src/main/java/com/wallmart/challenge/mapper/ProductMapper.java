package com.wallmart.challenge.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.wallmart.challenge.dto.ProductDTO;
import com.wallmart.challenge.entity.Product;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

//    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    
    ProductDTO productToProductDTO(Product product);
    List<ProductDTO> productListToProductDTOList(List<Product> productList);
}
