package com.example.dkeralutiveservice.productcategory.repository;

import com.example.dkeralutiveservice.productcategory.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Productcategoryrepository extends JpaRepository<ProductCategory, Long> {

    ProductCategory findByCode(String code);
}
