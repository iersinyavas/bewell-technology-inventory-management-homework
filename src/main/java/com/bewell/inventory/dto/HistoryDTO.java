package com.bewell.inventory.dto;

import lombok.*;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDTO {
    private Long historyId;
    private String operationStatusCode;
    private LocalDateTime transactionDate;
    private Long productId;
}
