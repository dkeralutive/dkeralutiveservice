package com.example.dkeralutiveservice.products.model;

import com.example.dkeralutiveservice.user.model.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Products extends AbstractEntity {

    private String type;
    private String code;

}
