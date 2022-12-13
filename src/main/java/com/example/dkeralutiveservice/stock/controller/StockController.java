package com.example.dkeralutiveservice.stock.controller;

import com.example.dkeralutiveservice.productdescription.dto.ProductDescriptionDto;
import com.example.dkeralutiveservice.productdescription.resp.ProductDescriptionResponse;
import com.example.dkeralutiveservice.stock.dto.StockDto;
import com.example.dkeralutiveservice.stock.resp.StockResponse;
import com.example.dkeralutiveservice.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/stock", produces = {MediaType.APPLICATION_JSON_VALUE})
public class StockController {

    @Autowired
    StockService stockService;


    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public ResponseEntity<StockResponse> addStock(@RequestBody StockDto stockDto) {
        StockResponse responseDto= stockService.addStock(stockDto);
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<StockResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<StockResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public ResponseEntity<StockResponse> updateStock(@RequestBody StockDto stockDto) {
        StockResponse responseDto= stockService.updateStock(stockDto);
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<StockResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<StockResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/delete" ,method = RequestMethod.POST)
    public ResponseEntity<StockResponse> deleteStock(@RequestBody StockDto stockDto) {
        StockResponse responseDto= stockService.deleteStock(stockDto);
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<StockResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<StockResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
