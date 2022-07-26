package com.dequevedo.pocspringboot.service;

import com.dequevedo.pocspringboot.exception.NotFoundException;
import com.dequevedo.pocspringboot.model.domain.ProductDomain;
import com.dequevedo.pocspringboot.model.request.ProductRequest;
import com.dequevedo.pocspringboot.model.response.ProductResponse;
import com.dequevedo.pocspringboot.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        log.info("Creating new product with name: {}", productRequest.getName());

        ProductDomain productDomain = productRepository.save(ProductDomain.valueOf(productRequest));

        return ProductResponse.valueOf(productDomain);
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

        ProductDomain productDomain = productRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Product not found.");
                    throw new NotFoundException();
                });

        log.info("Product retrieved: {}", productDomain);

        return ProductResponse.valueOf(productDomain);
    }

}
