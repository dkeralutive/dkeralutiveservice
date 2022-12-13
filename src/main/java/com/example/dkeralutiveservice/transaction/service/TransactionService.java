package com.example.dkeralutiveservice.transaction.service;

import com.example.dkeralutiveservice.transaction.dto.TransactionDto;
import com.example.dkeralutiveservice.transaction.resp.TransactionResponse;

public interface TransactionService {


    TransactionResponse addTransactionRecord(TransactionDto transactionDto);

}
