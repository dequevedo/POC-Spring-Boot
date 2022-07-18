package com.dequevedo.POCSpringBoot.model.domain;

import com.dequevedo.POCSpringBoot.model.request.ProductRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class ProductDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "internal_tag", columnDefinition = "VARCHAR(255)")
    private UUID internalTag;

    public static ProductDomain valueOf(ProductRequest productRequest) {
        return ProductDomain.builder()
                .name(productRequest.getName())
                .build();
    }
}