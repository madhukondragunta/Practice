package com.self.practice.service;

import com.self.practice.dto.Product;
import com.self.practice.repository.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Cacheable(value = "products", key = "#id")
    public Product getProductById(Integer id) {
        System.out.println("Fetching product from MongoDB for ID: " + id);
        return productRepository.findById(id).orElse(null);
    }

    @CachePut(value = "products", key = "#product.id")
    public Product saveProduct(Product product) {
        System.out.println("Saving product to MongoDB: " + product.getName());
        return productRepository.save(product);
    }

    @CacheEvict(value = "products", key = "#id")
    public void deleteProduct(Integer id) {
        System.out.println("Deleting product from MongoDB with ID: " + id);
        productRepository.deleteById(id);
    }
}
