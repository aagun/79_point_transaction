package com.tujuhsembilan.pointtransaction.controller;

import com.tujuhsembilan.pointtransaction.dto.ResponseDto;
import com.tujuhsembilan.pointtransaction.dto.TransactionsCustomerRequest;
import com.tujuhsembilan.pointtransaction.dto.TransactionsRequest;
import com.tujuhsembilan.pointtransaction.service.TransactionsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
@AllArgsConstructor
public class TransactionsController {

    private final TransactionsService transactionsService;

    @PostMapping
    public ResponseDto saveTransaction(@RequestBody TransactionsRequest transactionsRequest) {
        return transactionsService.saveTransaction(transactionsRequest);
    }

    @GetMapping
    public ResponseDto getTransactions() {
        return transactionsService.getAllTransactions();
    }


    @PostMapping("/{accountId}")
    public ResponseDto getAllTransactionsByAccountId(
            @PathVariable Integer accountId,
            @RequestBody TransactionsCustomerRequest transactionDateRange) {

        return transactionsService.getTransactionsByAccountId(accountId, transactionDateRange);
    }

}
