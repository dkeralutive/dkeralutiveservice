package com.example.dkeralutiveservice.productcategory.model;

import com.example.dkeralutiveservice.products.model.Products;
import com.example.dkeralutiveservice.user.model.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
public class ProductCategory extends AbstractEntity {

    @ManyToOne
    private Products products;
    private String category;
    private String code;

}
