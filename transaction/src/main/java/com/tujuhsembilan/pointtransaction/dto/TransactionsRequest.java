package com.tujuhsembilan.pointtransaction.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tujuhsembilan.pointtransaction.helper.LocalDateToLocalDateTimeDeserializer;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsRequest {
    private Integer accountId;
    @JsonDeserialize(using = LocalDateToLocalDateTimeDeserializer.class)
    private LocalDateTime transactionDate;
    private String description;
    private String debitCreditStatus;
    private Double amount;
}
