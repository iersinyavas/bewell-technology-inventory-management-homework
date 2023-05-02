package com.bewell.inventory.service;

import com.bewell.inventory.dao.WarehouseDAO;
import com.bewell.inventory.dto.WarehouseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseDAO warehouseDAO;

    public WarehouseDTO getWarehouse(String warehouseName) {
        return warehouseDAO.getWarehouse(warehouseName);
    }

    public WarehouseDTO getWarehouse(Long warehouseId) {
        return warehouseDAO.getWarehouse(warehouseId);
    }

    public WarehouseDTO addWarehouse(WarehouseDTO warehouseDTO) {
        WarehouseDTO warehouse = this.getWarehouse(warehouseDTO.getName());
        if (Objects.nonNull(warehouse)){
            return warehouse;
        }
        return warehouseDAO.addWarehouse(warehouseDTO);
    }

    public List<WarehouseDTO> getWarehouseList() {
        return warehouseDAO.getWarehouseList();
    }
}
