package com.bewell.inventory.request;

import com.bewell.inventory.dto.ProductDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class InventoryTransactionRequest {

    private String operationStatusCode;
    private LocalDateTime transactionDate;
    private ProductDTO productDTO;

}
