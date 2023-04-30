package com.bewell.inventory.controller;

import com.bewell.inventory.entity.Warehouse;
import com.bewell.inventory.request.InventoryTransactionRequest;
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


}
