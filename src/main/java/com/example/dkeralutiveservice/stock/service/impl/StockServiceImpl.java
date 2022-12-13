package com.example.dkeralutiveservice.stock.service.impl;

import com.example.dkeralutiveservice.response.ResponseDto;
import com.example.dkeralutiveservice.stock.dto.StockDto;
import com.example.dkeralutiveservice.stock.model.Stock;
import com.example.dkeralutiveservice.stock.repository.StockRepository;
import com.example.dkeralutiveservice.stock.resp.StockResponse;
import com.example.dkeralutiveservice.stock.service.StockService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    StockRepository stockRepository;
    @Autowired
    MessageSource messageSource;

    @Override
    public StockResponse addStock(StockDto stockDto) {
        ResponseDto responseDto=new ResponseDto();
        StockResponse stockResponse=new StockResponse();
        Stock stock=modelMapper.map(stockDto, Stock.class);
        stock.setStockStatus(true);
        stockRepository.save(stock);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("stock.add.success",null,Locale.ENGLISH));
        stockResponse.setResponseDto(responseDto);
        return stockResponse;
    }

    @Override
    public StockResponse updateStock(StockDto stockDto) {
        ResponseDto responseDto=new ResponseDto();
        StockResponse stockResponse=new StockResponse();
        Stock stock=stockRepository.findByStockCode(stockDto.getStockCode());
        stockDto.setId(stock.getId());
         Stock stock1=modelMapper.map(stockDto,Stock.class);
         stockRepository.save(stock1);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("stock.update.success",null,Locale.ENGLISH));
        stockResponse.setResponseDto(responseDto);
        return stockResponse;
    }

    @Override
    public StockResponse deleteStock(StockDto stockDto) {
         ResponseDto responseDto=new ResponseDto();
         StockResponse stockResponse=new StockResponse();
         Stock stock=  stockRepository.findByStockCode(stockDto.getStockCode());
         stock.setDelFlag("Y");
         stockRepository.save(stock);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("stock.delete.success",null,Locale.ENGLISH));
        stockResponse.setResponseDto(responseDto);
        return stockResponse;
    }
}
