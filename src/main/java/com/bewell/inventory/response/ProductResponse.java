package com.bewell.inventory.response;

import com.bewell.inventory.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {
    private ProductDTO productDTO;
}
