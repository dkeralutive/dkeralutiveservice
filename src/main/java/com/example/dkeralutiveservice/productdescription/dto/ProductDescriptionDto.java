package com.example.dkeralutiveservice.productdescription.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductDescriptionDto {
    private Long id;
    private BigDecimal amount;
    private String description;
    private String currency;
    private String imageUrl;
    private String productCode;
    private String code;
    private String productCategoryCode;

}
