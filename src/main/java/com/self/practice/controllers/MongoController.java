package com.self.practice.controllers;

import com.self.practice.dto.Product;
import com.self.practice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MongoController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public Product getProduct(@RequestParam(name="id")Integer id) {
        System.out.println("------ProductId----->"+id);
        return productService.getProductById(id);

    }

    @PostMapping("/product")
    public Product saveProduct(@RequestBody  Product product) {
        return productService.saveProduct(product);
    }

}
