package com.bewell.inventory.controller;

import com.bewell.inventory.dto.CategoryDTO;
import com.bewell.inventory.dto.ProductDTO;
import com.bewell.inventory.request.CategoryRequest;
import com.bewell.inventory.request.ProductRequest;
import com.bewell.inventory.response.BaseResponse;
import com.bewell.inventory.service.CategoryService;
import com.bewell.inventory.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping(value = "/{categoryName}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<BaseResponse<CategoryDTO>> getCategory(@PathVariable String categoryName) {
        return ResponseEntity.ok(new BaseResponse<>(categoryService.getCategory(categoryName)));
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<BaseResponse<CategoryDTO>> addCategory(@RequestBody CategoryRequest categoryRequest) {
        return ResponseEntity.ok(new BaseResponse<>(categoryService.addCategory(categoryRequest.getCategoryDTO())));
    }

    @GetMapping(value = "/category-list", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<BaseResponse<List<CategoryDTO>>> getCategoryList() {
        return ResponseEntity.ok(new BaseResponse<>(categoryService.getCategoryList()));
    }
}
