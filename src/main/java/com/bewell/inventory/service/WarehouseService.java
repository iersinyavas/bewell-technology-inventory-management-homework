package com.bewell.inventory.service;

import com.bewell.inventory.dao.WarehouseDAO;
import com.bewell.inventory.dto.ProductDTO;
import com.bewell.inventory.dto.WarehouseDTO;
import com.bewell.inventory.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseDAO warehouseDAO;

    public WarehouseDTO addWarehouse(WarehouseDTO warehouseDTO) {
        return warehouseDAO.addWarehouse(warehouseDTO);
    }
}
