package com.dequevedo.POCSpringBoot.controller;

import com.dequevedo.POCSpringBoot.model.request.ProductRequest;
import com.dequevedo.POCSpringBoot.model.response.ProductResponse;
import com.dequevedo.POCSpringBoot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse postProduct(@Valid @RequestBody ProductRequest product) {
        return productService.createProduct(product);
    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }
}