package com.example.dkeralutiveservice.productdescription.repository;

import com.example.dkeralutiveservice.productdescription.model.ProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDescriptionRepository  extends JpaRepository<ProductDescription, Long> {

    ProductDescription findByCode(String code);

    List<ProductDescription> findByProductCode(String productCode);

}
