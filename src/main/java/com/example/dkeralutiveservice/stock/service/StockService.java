package com.example.dkeralutiveservice.stock.service;

import com.example.dkeralutiveservice.stock.dto.StockDto;
import com.example.dkeralutiveservice.stock.resp.StockResponse;

public interface StockService {

    StockResponse addStock(StockDto stockDto);
    StockResponse updateStock(StockDto stockDto);
    StockResponse deleteStock(StockDto stockDto);


}
