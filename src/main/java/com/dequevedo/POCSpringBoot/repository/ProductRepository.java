package com.dequevedo.POCSpringBoot.repository;


import com.dequevedo.POCSpringBoot.model.domain.ProductDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductDomain, String> {
    List<ProductDomain> findAll();
}