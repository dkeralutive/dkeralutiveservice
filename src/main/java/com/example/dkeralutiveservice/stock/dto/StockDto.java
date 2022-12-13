package com.example.dkeralutiveservice.stock.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StockDto {

    private Long id;
    private String productDescriptionCode;
    private LocalDateTime dateTimeStock;
    private int quantity;
    private String productDescription;
    private String productType;
    private String productCategoryCode;
    private boolean stockStatus;
    private String stockCode;
}
