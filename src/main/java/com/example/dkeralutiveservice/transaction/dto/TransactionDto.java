package com.example.dkeralutiveservice.transaction.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class TransactionDto {

    private String currency;
    private String userName;
    private List<TransactionRecordDto> descriptionCode;

}
