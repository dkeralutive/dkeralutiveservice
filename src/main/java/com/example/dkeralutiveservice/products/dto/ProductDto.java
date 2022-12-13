package com.example.dkeralutiveservice.products.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ProductDto {

    private String code;
    private String type;
    private Long id;
    private Date createdOn;

}
