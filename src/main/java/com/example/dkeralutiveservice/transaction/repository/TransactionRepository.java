package com.example.dkeralutiveservice.transaction.repository;

import com.example.dkeralutiveservice.transaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository  extends JpaRepository<Transaction, Long>  {
}
