package com.bewell.inventory.dto;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long productId;
    private String name;
    private Long categoryId;
    private Long warehouseId;
    private BigDecimal quantity;
    private Integer criticalQuantity;

}
