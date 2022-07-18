package com.dequevedo.POCSpringBoot.service;

import com.dequevedo.POCSpringBoot.model.domain.ProductDomain;
import com.dequevedo.POCSpringBoot.model.request.ProductRequest;
import com.dequevedo.POCSpringBoot.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductRequest productRequest; //TODO renomear para CreateProductRequest

    /*
     * POST /products
     */

    @Test
    public void shouldCreateProductSuccessfully() {
        givenValidProductRequest();
        givenProductRepositorySaveReturnsProductDomain();
        whenProductServiceCreateProductCalled();
        thenExpectProductRepositorySaveCallOnce();
    }

    /**
     * Given methods
     */

    private void givenValidProductRequest() {
        productRequest = ProductRequest.builder()
                .name("Sample Product")
                .build();
    }

    private void givenProductRepositorySaveReturnsProductDomain() {
        doReturn(ProductDomain.builder()
                .name("Sample Product")
                .build())
                .when(productRepository).save(any(ProductDomain.class));
    }

    /**
     * When methods
     */

    public void whenProductServiceCreateProductCalled() {
        productService.createProduct(productRequest);
    }


    /**
     * Then methods
     */

    private void thenExpectProductRepositorySaveCallOnce() {
        verify(productRepository, times(1)).save(any(ProductDomain.class));
    }
}