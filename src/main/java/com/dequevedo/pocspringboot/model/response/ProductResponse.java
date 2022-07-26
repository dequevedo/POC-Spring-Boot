package com.dequevedo.pocspringboot.model.response;

import com.dequevedo.pocspringboot.model.domain.ProductDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private Long id;

    private String name;

    public static ProductResponse valueOf(ProductDomain domain) {
        return ProductResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }

}