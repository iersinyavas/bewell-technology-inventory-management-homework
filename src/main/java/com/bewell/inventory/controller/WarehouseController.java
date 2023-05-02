package com.bewell.inventory.controller;

import com.bewell.inventory.dto.WarehouseDTO;
import com.bewell.inventory.dto.WarehouseDTO;
import com.bewell.inventory.request.WarehouseRequest;
import com.bewell.inventory.request.WarehouseRequest;
import com.bewell.inventory.response.BaseResponse;
import com.bewell.inventory.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/warehouse")
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;

    @GetMapping(value = "/{warehouseName}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<BaseResponse<WarehouseDTO>> getWarehouse(@PathVariable String warehouseName) {
        return ResponseEntity.ok(new BaseResponse<>(warehouseService.getWarehouse(warehouseName)));
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<BaseResponse<WarehouseDTO>> addWarehouse(@RequestBody WarehouseRequest WarehouseRequest) {
        return ResponseEntity.ok(new BaseResponse<>(warehouseService.addWarehouse(WarehouseRequest.getWarehouseDTO())));
    }

    @GetMapping(value = "/warehouse-list", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<BaseResponse<List<WarehouseDTO>>> getWarehouseList() {
        return ResponseEntity.ok(new BaseResponse<>(warehouseService.getWarehouseList()));
    }
}
