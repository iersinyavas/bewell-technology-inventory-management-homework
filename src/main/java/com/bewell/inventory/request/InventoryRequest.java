package com.bewell.inventory.request;

import com.bewell.inventory.dto.ProductWarehouseDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class InventoryRequest {

    private ProductWarehouseDTO productWarehouseDTO;
    private BigDecimal transactionQuantity;

}
