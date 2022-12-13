package com.example.dkeralutiveservice.transaction.controller;


import com.example.dkeralutiveservice.stock.dto.StockDto;
import com.example.dkeralutiveservice.stock.resp.StockResponse;
import com.example.dkeralutiveservice.transaction.dto.TransactionDto;
import com.example.dkeralutiveservice.transaction.resp.TransactionResponse;
import com.example.dkeralutiveservice.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/transaction", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public ResponseEntity<TransactionResponse> addTransaction(@RequestBody TransactionDto transactionDto) {
        TransactionResponse responseDto= transactionService.addTransactionRecord(transactionDto);
        if(responseDto.getResponseDto().getCode().equalsIgnoreCase("dkss")){
            return new ResponseEntity<TransactionResponse>(responseDto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<TransactionResponse>(responseDto, HttpStatus.BAD_REQUEST);
    }

}






