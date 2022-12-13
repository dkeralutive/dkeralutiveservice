package com.example.dkeralutiveservice.transaction.service.implementation;

import com.example.dkeralutiveservice.response.ResponseDto;
import com.example.dkeralutiveservice.transaction.dto.TransactionDto;
import com.example.dkeralutiveservice.transaction.dto.TransactionRecordDto;
import com.example.dkeralutiveservice.transaction.model.Transaction;
import com.example.dkeralutiveservice.transaction.repository.TransactionRepository;
import com.example.dkeralutiveservice.transaction.resp.TransactionResponse;
import com.example.dkeralutiveservice.transaction.service.TransactionService;
import com.example.dkeralutiveservice.user.model.DekeralutiveUser;
import com.example.dkeralutiveservice.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Locale;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MessageSource messageSource;

    @Override
    public TransactionResponse addTransactionRecord(TransactionDto transactionDto) {
        ResponseDto responseDto=new ResponseDto();
        TransactionResponse transactionResponse=new TransactionResponse();
        boolean result=processTransaction(transactionDto);
        responseDto.setCode(messageSource.getMessage("dk.success",null, Locale.ENGLISH));
        responseDto.setMessage(messageSource.getMessage("transaction.add.success",null,Locale.ENGLISH));
        transactionResponse.setResponseDto(responseDto);
        return transactionResponse;
    }

    private boolean processTransaction(TransactionDto transactionDto){
        DekeralutiveUser dekeralutiveUser= userRepository.findByUserName(transactionDto.getUserName());
        Transaction transaction=new Transaction();
        for(TransactionRecordDto recordDto:transactionDto.getDescriptionCode()){
            transaction.setTransactionDate(LocalDateTime.now());
            transaction.setCurrency(transactionDto.getCurrency());
            transaction.setDekeralutiveUser(dekeralutiveUser);
            transaction.setAmount(recordDto.getAmount());
            transaction.setDescription(recordDto.getProductDescription());
            transaction.setDescriptionCode(recordDto.getProductDescriptionCode());
            transaction.setProductCategoryCode(recordDto.getProductCategoryCode());
            transaction.setProductCode(recordDto.getProductCode());
        }
        transactionRepository.save(transaction);
        return true;
    }
}
