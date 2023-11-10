package com.tujuhsembilan.pointtransaction.service;

import com.tujuhsembilan.pointtransaction.dao.TransactionsDao;
import com.tujuhsembilan.pointtransaction.dto.ResponseDto;
import com.tujuhsembilan.pointtransaction.dto.TransactionsCustomerRequest;
import com.tujuhsembilan.pointtransaction.dto.TransactionsRequest;
import com.tujuhsembilan.pointtransaction.helper.ResponseDtoHelper;
import com.tujuhsembilan.pointtransaction.model.Transactions;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionsService {

    private final TransactionsDao transactionsDao;

    public ResponseDto saveTransaction(TransactionsRequest transactionsRequest) {
        Transactions transactions = transactionsDao.save(
                Transactions.builder()
                        .accountId(1)
                        .transactionDate(transactionsRequest.getTransactionDate())
                        .description(transactionsRequest.getDescription())
                        .debitCreditStatus(transactionsRequest.getDebitCreditStatus())
                        .amount(transactionsRequest.getAmount())
                        .build()
        );


        if (transactions == null) {
            return ResponseDtoHelper.fail();
        }

        return ResponseDtoHelper.ok();
    }

    public ResponseDto getAllTransactions() {
        List<Transactions> transactions = transactionsDao.findAll();
        return ResponseDtoHelper.ok(transactions);
    }

    public ResponseDto getTransactionsByAccountId(Integer accountId, TransactionsCustomerRequest transactionDateRange) {
        Optional<List<Transactions>> transactions = transactionsDao
                .findByAccountIdAndTransactionDateBetween(
                        accountId,
                        transactionDateRange.getStartDate(),
                        transactionDateRange.getEndDate());

        return ResponseDtoHelper.ok(transactions.orElse(Collections.emptyList()));
    }
}
