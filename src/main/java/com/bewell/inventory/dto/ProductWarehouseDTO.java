package com.bewell.inventory.dto;

import com.bewell.inventory.entity.Product;
import com.bewell.inventory.entity.Warehouse;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductWarehouseDTO {

    private Long productWarehouseId;
    private String productName;
    private Long warehouseId;
    private BigDecimal quantity;
    private BigDecimal criticalQuantity;
}
