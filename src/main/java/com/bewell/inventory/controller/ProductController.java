package com.bewell.inventory.controller;

import com.bewell.inventory.dto.ProductDTO;
import com.bewell.inventory.entity.Product;
import com.bewell.inventory.request.ProductRequest;
import com.bewell.inventory.response.BaseResponse;
import com.bewell.inventory.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<BaseResponse<ProductDTO>> getProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(new BaseResponse<>(productService.getProduct(productId)));
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<BaseResponse<ProductDTO>> addProduct(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(new BaseResponse<>(productService.addProduct(productRequest.getProductDTO())));
    }

    @DeleteMapping(value = "/product", produces = MediaType.APPLICATION_JSON)
    public void deleteProduct(Long productId) {

    }


}
