package com.bewell.inventory.controller;

import com.bewell.inventory.dto.WarehouseDTO;
import com.bewell.inventory.request.WarehouseRequest;
import com.bewell.inventory.response.BaseResponse;
import com.bewell.inventory.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/warehouse")
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<BaseResponse<WarehouseDTO>> addWarehouse(@RequestBody WarehouseRequest warehouseRequest) {
        WarehouseDTO warehouseDTO = warehouseService.addWarehouse(warehouseRequest.getWarehouseDTO());
        return ResponseEntity.ok(new BaseResponse<>(warehouseDTO));
    }
}
