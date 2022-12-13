package com.example.dkeralutiveservice.stock.model;

import com.example.dkeralutiveservice.user.model.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Data
public class Stock extends AbstractEntity {

    private String productDescriptionCode;
    private LocalDateTime dateTimeStock;
    private int quantity;
    private String productDescription;
    private String productType;
    private String productCategoryCode;
    private boolean stockStatus;
    private String stockCode;

}
