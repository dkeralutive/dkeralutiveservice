package com.example.dkeralutiveservice.transaction.model;

import com.example.dkeralutiveservice.user.model.AbstractEntity;
import com.example.dkeralutiveservice.user.model.DekeralutiveUser;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Transaction extends AbstractEntity {

    private LocalDateTime transactionDate;
    private BigDecimal amount;
    private String descriptionCode;
    private String description;
    private String  currency;
    private String productCode;
    private String productCategoryCode;
    @ManyToOne
    private DekeralutiveUser dekeralutiveUser;




}
