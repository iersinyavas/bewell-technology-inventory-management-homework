package com.bewell.inventory.controller;

import com.bewell.inventory.dto.ProductDTO;
import com.bewell.inventory.dto.ProductWarehouseDTO;
import com.bewell.inventory.dto.WarehouseDTO;
import com.bewell.inventory.request.InventoryRequest;
import com.bewell.inventory.request.ProductRequest;
import com.bewell.inventory.response.BaseResponse;
import com.bewell.inventory.service.InventoryService;
import com.bewell.inventory.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;
    private final ProductService productService;

    @GetMapping(value = "/product-which-warehouse", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<List<WarehouseDTO>> productWhichWarehouse(@RequestParam String productName){
        return ResponseEntity.ok(inventoryService.productWhichWarehouse(productName));
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<BaseResponse<ProductWarehouseDTO>> addProductWarehouse(@RequestBody InventoryRequest inventoryRequest) {
        return ResponseEntity.ok(new BaseResponse<>(inventoryService.addProductWarehouse(inventoryRequest)));
    }

    @PostMapping(value = "/add-quantity-product", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<BaseResponse<ProductWarehouseDTO>> addQuantityProduct(@RequestBody InventoryRequest inventoryRequest) {
        return ResponseEntity.ok(new BaseResponse<>(inventoryService.addQuantityProduct(inventoryRequest)));
    }

    @PostMapping(value = "/subtract-quantity-product", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<BaseResponse<ProductWarehouseDTO>> subtractQuantity(@RequestBody InventoryRequest inventoryRequest) {
        return ResponseEntity.ok(new BaseResponse<>(inventoryService.subtractQuantity(inventoryRequest)));
    }

}
