package com.bewell.inventory.dto;

import com.bewell.inventory.entity.Product;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

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

    public boolean equals(Product o) {
        if(Objects.isNull(o)){
            return false;
        }
        return Objects.equals(name, o.getName()) &&
                Objects.equals(categoryId, o.getCategory().getCategoryId()) &&
                Objects.equals(warehouseId, o.getWarehouse().getWarehouseId());
    }

}
