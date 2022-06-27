package com.dequevedo.POCSpringBoot.controllers;

import com.dequevedo.POCSpringBoot.model.Product;
import com.dequevedo.POCSpringBoot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/products")
    public Product postProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

}