package com.bewell.inventory.request;

import com.bewell.inventory.dto.ProductDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private ProductDTO productDTO;
}
