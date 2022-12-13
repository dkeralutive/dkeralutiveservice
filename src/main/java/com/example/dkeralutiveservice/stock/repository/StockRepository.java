package com.example.dkeralutiveservice.stock.repository;

import com.example.dkeralutiveservice.stock.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository  extends JpaRepository<Stock, Long> {

    Stock findByStockCode(String stockCode);
}
