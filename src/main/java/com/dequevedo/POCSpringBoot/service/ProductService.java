package com.dequevedo.POCSpringBoot.service;

import com.dequevedo.POCSpringBoot.exception.NotFoundException;
import com.dequevedo.POCSpringBoot.model.Product;
import com.dequevedo.POCSpringBoot.model.request.ProductRequest;
import com.dequevedo.POCSpringBoot.model.response.ProductResponse;
import com.dequevedo.POCSpringBoot.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        log.info("Creating new product with name: {}", productRequest.getName());

        Product product = productRepository.save(Product.valueOf(productRequest));

        return ProductResponse.valueOf(product);
    }

    public List<ProductResponse> getProducts(){
        log.info("Getting all products");

        List<ProductResponse> productsResponse = productRepository
                .findAll().stream()
                .map(ProductResponse::valueOf).toList();

        log.info("Products retrieved: {}", productsResponse);

        return productsResponse;
    }

    public ProductResponse getProductById(String id){
        log.info("Getting Product with id: {}", id);

        Product product = productRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Product not found.");
                    throw new NotFoundException();
                });

        log.info("Product retrieved: {}", product);

        return ProductResponse.valueOf(product);
    }

}
