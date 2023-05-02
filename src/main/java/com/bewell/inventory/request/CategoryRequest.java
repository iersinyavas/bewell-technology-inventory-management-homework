package com.bewell.inventory.request;

import com.bewell.inventory.dto.CategoryDTO;
import com.bewell.inventory.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
    private CategoryDTO categoryDTO;
}
