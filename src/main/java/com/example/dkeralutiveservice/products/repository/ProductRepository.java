package com.example.dkeralutiveservice.products.repository;

import com.example.dkeralutiveservice.products.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {

    Products findByCode(String code);
}
