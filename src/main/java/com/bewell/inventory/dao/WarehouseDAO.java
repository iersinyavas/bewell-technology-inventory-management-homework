package com.bewell.inventory.dao;

import com.bewell.inventory.dto.WarehouseDTO;
import com.bewell.inventory.entity.Warehouse;
import com.bewell.inventory.mapper.WarehouseMapper;
import com.bewell.inventory.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class WarehouseDAO {

    private final WarehouseRepository warehouseRepository;

    public WarehouseDTO getWarehouse(Long warehouseId){
        return WarehouseMapper.INSTANCE.entityToDTO(warehouseRepository.findById(warehouseId).get());
    }

    public WarehouseDTO getWarehouse(String warehouseName){
        return WarehouseMapper.INSTANCE.entityToDTO(warehouseRepository.findByName(warehouseName));
    }

    public WarehouseDTO addWarehouse(WarehouseDTO warehouseDTO) {
        Warehouse warehouse = WarehouseMapper.INSTANCE.dtoToEntity(warehouseDTO);
        return WarehouseMapper.INSTANCE.entityToDTO(warehouseRepository.save(warehouse));
    }

    public List<WarehouseDTO> getWarehouseByProduct(String warehouseName){
        return null;//WarehouseMapper.INSTANCE.entityToDTO(warehouseRepository.productWhichWarehouse(warehouseName));
    }

}
