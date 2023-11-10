package com.tujuhsembilan.pointtransaction.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {
    @Id
    private String id;
    private Integer accountId;
    private LocalDateTime transactionDate;
    private String description;
    private String debitCreditStatus;
    private Double amount;
}
