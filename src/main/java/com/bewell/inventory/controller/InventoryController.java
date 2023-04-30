package com.bewell.inventory.controller;

import com.bewell.inventory.dto.ProductDTO;
import com.bewell.inventory.entity.Warehouse;
import com.bewell.inventory.request.InventoryTransactionRequest;
import com.bewell.inventory.request.ProductRequest;
import com.bewell.inventory.response.BaseResponse;
import com.bewell.inventory.service.InventoryService;
import com.bewell.inventory.service.ProductService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;
    private final ProductService productService;

    @PostMapping(value = "/inventory-transaction", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Boolean> inventoryTransaction(@RequestBody InventoryTransactionRequest inventoryTransactionRequest){
        inventoryService.inventoryTransaction(inventoryTransactionRequest);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping(value = "/product-which-warehouse", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<Boolean> productWhichWarehouse(@RequestBody InventoryTransactionRequest inventoryTransactionRequest){
        inventoryService.productWhichWarehouse(inventoryTransactionRequest.getProductDTO().getName());
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<BaseResponse<ProductDTO>> getProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(new BaseResponse<>(productService.getProduct(productId)));
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<BaseResponse<ProductDTO>> addProduct(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(new BaseResponse<>(productService.addProduct(productRequest.getProductDTO())));
    }

    @PostMapping(value = "/add-quantity", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<BaseResponse<ProductDTO>> addQuantity(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(new BaseResponse<>(productService.addQuantity(productRequest.getProductDTO())));
    }

    @PostMapping(value = "/subtract-quantity", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<BaseResponse<ProductDTO>> subtractQuantity(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(new BaseResponse<>(productService.subtractQuantity(productRequest.getProductDTO())));
    }

    @DeleteMapping(value = "/product", produces = MediaType.APPLICATION_JSON)
    public void deleteProduct(Long productId) {

    }


}
