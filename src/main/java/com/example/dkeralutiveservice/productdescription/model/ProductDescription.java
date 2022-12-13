package com.example.dkeralutiveservice.productdescription.model;

import com.example.dkeralutiveservice.productcategory.model.ProductCategory;
import com.example.dkeralutiveservice.user.model.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Data
public class ProductDescription  extends AbstractEntity {

    private BigDecimal amount;
    private String description;
    private String currency;
    private String imageUrl;
    @ManyToOne
    private ProductCategory productCategory;

    private String productCode;

    private String code;


}
