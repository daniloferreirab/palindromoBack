package com.wallmart.challenge.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wallmart.challenge.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

    public List<Product> findAllById(Integer id);
        
    public List<Product> findByBrand(String brand);
    
    public List<Product> findByDescription(String description);
    
}
