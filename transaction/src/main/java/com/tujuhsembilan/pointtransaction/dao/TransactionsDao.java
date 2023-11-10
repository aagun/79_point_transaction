package com.tujuhsembilan.pointtransaction.dao;

import com.tujuhsembilan.pointtransaction.model.Transactions;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionsDao extends MongoRepository<Transactions, Integer> {
    Optional<List<Transactions>> findByAccountIdAndTransactionDateBetween(Integer accountId, LocalDateTime start, LocalDateTime end);
}

