package com.tujuhsembilan.pointtransaction.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tujuhsembilan.pointtransaction.helper.LocalDateToLocalDateTimeDeserializer;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionsCustomerRequest {

    @JsonDeserialize(using = LocalDateToLocalDateTimeDeserializer.class)
    private LocalDateTime startDate;

    @JsonDeserialize(using = LocalDateToLocalDateTimeDeserializer.class)
    private LocalDateTime endDate;
}
