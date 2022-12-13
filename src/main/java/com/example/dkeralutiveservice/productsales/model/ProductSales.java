package com.example.dkeralutiveservice.productsales.model;

import com.example.dkeralutiveservice.user.model.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class ProductSales extends AbstractEntity {

    private long totalQuantityAvailble;
    private long totalQuantitySold;
    private String productDescription;
    private String productDescriptionCode;
    private String productCode;
    private String productCategoryCode;
}
